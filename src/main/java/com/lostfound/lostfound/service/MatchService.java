package com.lostfound.lostfound.service;

import java.util.List;

import com.lostfound.lostfound.dto.MatchRequestDto;
import com.lostfound.lostfound.dto.MatchResponseDto;

public interface MatchService {

    List<MatchResponseDto> getAllMatches();

    MatchResponseDto getMatchById(Long matchId);

    MatchResponseDto createMatch(MatchRequestDto request);

    MatchResponseDto confirmMatch(Long matchId);

    MatchResponseDto rejectMatch(Long matchId); // consistent naming
}