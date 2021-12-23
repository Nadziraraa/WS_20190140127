/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c.mahasiswa7.tugas.assesment;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller

public class DataController {

    /**
     *
     * @return
     */
    @CrossOrigin
     @RequestMapping(value = "/datamahasiswati/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Datamahasiswati> getDataMahasiswatiXML() {
        List<Datamahasiswati> datamahasiswati = new ArrayList<>();
        
        DatamahasiswatiJpaController controller = new DatamahasiswatiJpaController();
        
        try {
            datamahasiswati = controller.findDatamahasiswatiEntities();
        } catch (Exception e) {}
        return datamahasiswati;
  
    } 
    
    @CrossOrigin
    @RequestMapping(value = "/datamahasiswati/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    
    public List<Datamahasiswati> getDataMahasiswatiJSON() {
    
        
        List <Datamahasiswati> datamahasiswati = new ArrayList<>();
        
        DatamahasiswatiJpaController controller = new DatamahasiswatiJpaController();
        
        try {
            datamahasiswati = controller.findDatamahasiswatiEntities();
        } catch (Exception e) {}
        
        return datamahasiswati;
    }           
}

