package com.uchuang.gamereport.repo;

import stone.dal.jdbc.api.StJpaRepository;
import com.uchuang.gamereport.jpa.Report;

public interface ReportRepository extends StJpaRepository<Report, String> {

}