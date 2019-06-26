package com.dmarchante.kiddoh.implementations;

import java.util.List;
import java.util.Map;

public interface DashboardService {
    List<List<Map<Object, Object>>> getDashboardData();
}