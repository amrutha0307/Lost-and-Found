package com.lostfound.lostfound.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lostfound.lostfound.dto.MatchRequestDto;
import com.lostfound.lostfound.dto.MatchResponseDto;
import com.lostfound.lostfound.model.Match;
import com.lostfound.lostfound.repository.MatchRepository;
import com.lostfound.lostfound.service.MatchService;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {
    private static final Logger log = LoggerFactory.getLogger(MatchServiceImpl.class);
    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<MatchResponseDto> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MatchResponseDto getMatchById(Long matchId) {
        return matchRepository.findById(matchId)
                .map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Match not found: " + matchId));
    }

    @Override
    public MatchResponseDto createMatch(MatchRequestDto request) {
        Match match = new Match(request.getLostItemId(), request.getFoundItemId(), "PENDING");
        Match saved = matchRepository.save(match);
        log.info("Created new match request for lostItemId={} and foundItemId={}", request.getLostItemId(), request.getFoundItemId());
        return toDto(saved);
    }

    @Override
    public MatchResponseDto confirmMatch(Long matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException("Match not found: " + matchId));

        match.setMatchStatus("CONFIRMED");
        Match saved = matchRepository.save(match);
        sendMatchNotification(saved);
        return toDto(saved);
    }

    private void sendMatchNotification(Match match) {
        String notification = String.format(
                "Match confirmed for lost item %d and found item %d. Status=%s",
                match.getLostItemId(), match.getFoundItemId(), match.getMatchStatus());
        log.info("[MatchNotification] {}", notification);
    }

    private MatchResponseDto toDto(Match match) {
        return new MatchResponseDto(match.getId(), match.getLostItemId(), match.getFoundItemId(), match.getMatchStatus());
    }
}
