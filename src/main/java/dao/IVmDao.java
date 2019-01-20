package dao;

import model.Vm;

import java.util.List;

public interface IVmDao {
    List<Vm> findAllVm();
    Vm findVm(String id);
}
