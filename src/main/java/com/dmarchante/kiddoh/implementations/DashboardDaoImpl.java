package com.dmarchante.kiddoh.implementations;

import com.dmarchante.kiddoh.models.DashboardModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public abstract class DashboardDaoImpl implements DashboardDao {
    @Override
    public List<List<Map<Object, Object>>> getDashboardData() {
        return DashboardModel.getDashboardDataList();
    }
}
