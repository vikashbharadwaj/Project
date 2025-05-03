package com.bitsnbytes.productlist.service;

import com.bitsnbytes.productlist.dto.CateogryDto;
import com.bitsnbytes.productlist.entity.Category;
import com.bitsnbytes.productlist.exception.CateogryAlreadyExistException;
import com.bitsnbytes.productlist.mapper.CateogryMapper;
import com.bitsnbytes.productlist.repository.CateogryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CateogryService {
    private CateogryRepository cateogryRepository;

    //create cateogry
    public CateogryDto createCatogry(CateogryDto cateogryDto){
       Optional<Category> optionalCategory=cateogryRepository.findByName(cateogryDto.getName());
       if(optionalCategory.isPresent()){
           throw new CateogryAlreadyExistException("cateogry +" +
                  cateogryDto.getName()+ "alreay exist");
       }
       Category category= CateogryMapper.toCateogryEntity(cateogryDto);
       category=cateogryRepository.save(category);
      return CateogryMapper.toCateogryDto(category);

    }
    //get logic
  //  @MycustomAnnotation(key = "userkey")
    public List<CateogryDto> getAllCatogry(){
       return cateogryRepository.findAll().stream().map(CateogryMapper::toCateogryDto).toList();
    }
    public CateogryDto getCatogryById(Long id){
       Category category=cateogryRepository.findById(id).orElseThrow(()->new RuntimeException("catogry not found"));
      return CateogryMapper.toCateogryDto(category);
    }
    //delete cateogry
    public String deleteCateogry(Long id){
        cateogryRepository.deleteById(id);
        return "categry"+id+"has been deleted";
    }



    }
