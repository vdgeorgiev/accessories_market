package com.example.PhoneAccessories.Service;

import com.example.PhoneAccessories.Dto.CaseDto;
import com.example.PhoneAccessories.Model.Case;
import com.example.PhoneAccessories.Repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CaseService {

    private CaseRepository caseRepository;

    @Autowired
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }
    public void save(@NotNull Case item) {
        caseRepository.save(item);
    }
    public Set<CaseDto> returnAllCases() {
        List<Case> cases = caseRepository.findAll();
        Set<CaseDto> collection =new HashSet<>();
        for(Case item : cases) {
            CaseDto caseDto = new CaseDto();
            caseDto.setHeader(item.getHeader());
            caseDto.setPrice(item.getPrice());
            caseDto.setPcs(item.getPiece().getPieces());
            collection.add(caseDto);
        }
        return collection;
    }
    public void deleteById(@NotNull Long id) {
        caseRepository.deleteById(id);
    }
}
