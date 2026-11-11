package com.manager.service.impl;

import com.contract.model.VacanciesResponseDto;
import com.contract.model.VacancyDto;
import com.manager.model.entity.VacancyEntity;
import com.manager.repository.VacancyRepository;
import com.manager.service.VacancyService;
import com.contract.util.VacancyFilterParameters;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Не доработал логику сохранения вакансий. Поэтому пока что можно только получить вакансии.
 * **/
@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository repository;

    private final ModelMapper modelMapper;

    /**-----------------------------| SEND |-----------------------------**/

    @Override
    public List<VacancyDto> sendVacancies() {
        return List.of(modelMapper.map(repository.findAll(), VacancyDto.class));
    }

    /**
     * Необходимо доработать. Старая реализация оказалась нерабочей
     * **/
    @Override
    public List<VacancyDto> sendVacanciesFilter(VacancyFilterParameters filter) {
        return List.of();
    }

    @Override
    public VacancyDto sendVacancy(String vacancyId) {
        return modelMapper.map(repository.findByVacancyId(vacancyId), VacancyDto.class);
    }

    /**-----------------------------| PROCESS |-----------------------------**/

    @Override
    public void processVacancies(VacanciesResponseDto response) {
        response.items().stream().forEach(vacancy ->
            repository.save(modelMapper.map(vacancy, VacancyEntity.class)
        ));
    }

    @Override
    public void processVacancy(VacancyDto vacancy) {
        repository.save(modelMapper.map(vacancy, VacancyEntity.class));
    }
}
