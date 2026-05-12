package com.lostfound.lostfound.service.impl;

import com.lostfound.lostfound.dto.MatchRequestDto;
import com.lostfound.lostfound.dto.MatchResponseDto;
import com.lostfound.lostfound.model.Match;
import com.lostfound.lostfound.repository.MatchRepository;
import com.lostfound.lostfound.service.MatchService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository repository;

    public MatchServiceImpl(MatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MatchResponseDto> getAllMatches() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MatchResponseDto getMatchById(Long id) {
        Match match = repository.findById(id).orElseThrow();
        return mapToDto(match);
    }

    @Override
    public MatchResponseDto createMatch(MatchRequestDto request) {
        Match match = new Match();
        match.setLostItemId(request.getLostItemId());
        match.setFoundItemId(request.getFoundItemId());

        // ✅ FIXED
        match.setStatus("PENDING");

        Match saved = repository.save(match);
        return mapToDto(saved);
    }

    @Override
    public MatchResponseDto confirmMatch(Long id) {
        Match match = repository.findById(id).orElseThrow();

        // ✅ FIXED
        match.setStatus("APPROVED");

        repository.save(match);
        return mapToDto(match);
    }

    @Override
    public MatchResponseDto rejectMatch(Long id) {
        Match match = repository.findById(id).orElseThrow();

        // ✅ FIXED
        match.setStatus("REJECTED");

        repository.save(match);
        return mapToDto(match);
    }

    // ✅ HELPER
    private MatchResponseDto mapToDto(Match match) {
        MatchResponseDto dto = new MatchResponseDto();
        dto.setId(match.getId());
        dto.setLostItemId(match.getLostItemId());
        dto.setFoundItemId(match.getFoundItemId());

        // ✅ FIXED
        dto.setMatchStatus(match.getStatus());

        return dto;
    }
}