package com.dmarchante.kiddoh.implementations;

import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

public interface DashboardDao {
    List<List<Map<Object, Object>>> getDashboardData();
}


