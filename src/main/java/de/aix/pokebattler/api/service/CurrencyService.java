package de.aix.pokebattler.api.service;

import de.aix.pokebattler.api.repository.CurrencyRepository;
import de.aix.pokebattler.model.currency.Currency;
import de.aix.pokebattler.model.currency.CurrencyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Transactional(readOnly = true)
    public List<CurrencyDTO> getAllCurrencies() {
        return currencyRepository.findAll().stream()
            .map(this::toDTO)
            .toList();
    }

    @Transactional(readOnly = true)
    public Optional<CurrencyDTO> getCurrencyById(Long id) {
        return currencyRepository.findById(id)
            .map(this::toDTO);
    }

    @Transactional
    public CurrencyDTO createCurrency(CurrencyDTO request) {
        Currency entity = Currency.builder()
            .id(request.getId())
            .name(request.getName())
            .build();

        Currency saved = currencyRepository.save(entity);

        return toDTO(saved);
    }

    @Transactional
    public Optional<CurrencyDTO> updateCurrency(Long id, CurrencyDTO request) {
        return currencyRepository.findById(id).map(currency -> {
            currency.setName(request.getName());
            Currency updated = currencyRepository.save(currency);

            return toDTO(updated);
        });
    }

    @Transactional
    public boolean deleteCurrency(Long id) {
        if (currencyRepository.existsById(id)) {
            currencyRepository.deleteById(id);

            return true;
        }

        return false;
    }

    private CurrencyDTO toDTO(Currency entity) {
        if (entity == null)
            return null;

        return CurrencyDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .build();
    }
}
