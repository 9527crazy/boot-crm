package com.example.bootcrm.Controller;

import com.example.bootcrm.DTO.ExecuteDTO;
import com.example.bootcrm.DTO.PageQueryParamDTO;
import com.example.bootcrm.DTO.PageResultDTO;
import com.example.bootcrm.dao.Member;
import com.example.bootcrm.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * FileName: MemberController
 * Author:   刘帅
 * Date:     2019-5-30 20:52
 */
@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberRepository repository;

    @GetMapping("get/{id}")
    public Member get(@PathVariable String id){
        return repository.findById(id).orElse(null);
    }
    @PostMapping("save")
    public ExecuteDTO save(@RequestBody Member entity){
        if (entity.date==null){
            entity.date=new Date();
        }
        repository.save(entity);
        return new ExecuteDTO(true,"保存成功",entity.id);
    }
    @PostMapping("loadPage")
    public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params){
        //动态查询条件
        Specification<Member> spec=(root, query, cb) -> {
            if (params.getQuery()!=null){
                //筛选 会员名单
                query.where(cb.equal(root.get("name"),params.getQuery().toString()));
            }
            return null;
        };
        Pageable pageable=PageRequest.of(params.getPage()-1,params.getSize());
        Page<Member> pageResult=repository.findAll(spec,pageable);
        return new PageResultDTO(pageResult.getTotalElements(),pageResult.getContent());
    }
    @GetMapping("remove/{id}")
    public ExecuteDTO remove(@PathVariable String id){
        repository.deleteById(id);
        return new ExecuteDTO(true,"删除成功",id);
    }
}
