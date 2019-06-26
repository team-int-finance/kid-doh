package com.dmarchante.kiddoh.implementations;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private DashboardDao dashboardDao;

    public void setDashboardDao(DashboardDao dashboardDao) {
        this.dashboardDao = dashboardDao;
    }

    @Override
    public List<List<Map<Object, Object>>> getDashboardData() {
        return dashboardDao.getDashboardData();
    }
}
