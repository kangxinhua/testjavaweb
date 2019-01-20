package service;

import dao.VmDao;
import model.Vm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VmService implements IVmService {
    @Autowired
    private VmDao vmDao;
    @Override
    public List<Vm> findAllVm(){
        return vmDao.findAllVm();
    }
}
