package Interfaces;

import java.util.List;

import Modelo.Suministro;


public interface SupplyRepository {
	
    List<Suministro> getAllSupply(); 
    
    Suministro getSupplyById(int id); 
    
    void addSupply(Suministro Supply); 
    
    boolean updateSupply(Suministro Supply); 
    
    void deleteSupply(int id);

}