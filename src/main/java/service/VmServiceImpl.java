package service;

import dao.IVmDao;
import model.Vm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VmServiceImpl implements IVmService {
    @Autowired
    private IVmDao vmDao;
    @Override
    public List<Vm> findAllVm(){
        return vmDao.findAllVm();
    }
}
