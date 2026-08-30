package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.LanguageRepository;
import de.aix.pokebattler.model.utility.Language;
import de.aix.pokebattler.model.utility.LanguageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<LanguageDTO> getAllLanguages() {
        return languageRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<LanguageDTO> getLanguageById(Long id) {
        return languageRepository.findById(id)
                .map(this::toDTO);
    }

    public Optional<LanguageDTO> getLanguageByName(String name) {
        return languageRepository.findByNameIgnoreCase(name)
                .map(this::toDTO);
    }

    public LanguageDTO toDTO(Language language) {
        if (language == null)
            return null;

        LanguageDTO dto = new LanguageDTO();
        dto.setId(language.getId());
        dto.setName(language.getName());
        dto.setOfficial(language.getOfficial());
        dto.setIso639(language.getIso639());
        dto.setIso3166(language.getIso3166());

        return dto;
    }
}
