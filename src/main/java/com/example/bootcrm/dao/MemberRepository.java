package com.example.bootcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * FileName: MemberRepository
 * Author:   刘帅
 * Date:     2019-5-30 20:41
 */
public interface MemberRepository extends JpaRepository<Member,String>, JpaSpecificationExecutor<Member> {
}
