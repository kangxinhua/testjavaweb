package service;

import model.Vm;

import java.util.List;

public interface IVmService {
    List<Vm> findAllVm();

    Vm findVm(String id);
}
