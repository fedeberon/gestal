package com.ideaas.web.controller;

import com.google.common.collect.Lists;
import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.domain.certificado.CertificadoTipo;
import com.ideaas.services.domain.certificado.Imagen;
import com.ideaas.services.service.FileServiceImpl;
import com.ideaas.services.service.interfaces.CertificadoService;
import com.ideaas.services.service.interfaces.ColaboradorService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("certificado")
public class CertificadoController {

    private CertificadoService certificadoService;
    private ColaboradorService colaboradorService;
    private FileServiceImpl fileService;


    private static String UPLOADED_FOLDER = "C:"+File.separator+"Users"+File.separator+"enzo"+File.separator+"spring_upload_example"+File.separator+"";

    @Autowired
    public CertificadoController(CertificadoService certificadoService, ColaboradorService colaboradorService, FileServiceImpl fileService) {
        this.certificadoService = certificadoService;
        this.colaboradorService = colaboradorService;
        this.fileService = fileService;
    }

    @RequestMapping(value = "save")
    public String save(Certificado certificado){
        certificadoService.save(certificado);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Certificado certificado = certificadoService.get(id);
        model.addAttribute("certificado", certificado);
        model.addAttribute("idCertificado", certificado);

        return "certificado/update";
    }

    @RequestMapping("create")
    public String create(@ModelAttribute("certificado") Certificado certificado, Model model) {
        return "certificado/create";
    }


    @ModelAttribute("certificados")
    public CertificadoTipo[] getCertificados() {

        return CertificadoTipo.values();
    }

    @ModelAttribute("colaboradores")
    public List<Colaborador> getColaboradores() {

        return colaboradorService.findAll();
    }

    @RequestMapping("/list")
    public String findAllPageable(@RequestParam(defaultValue = "10") Integer size,
                                  @RequestParam(defaultValue = "0") Integer page, Model model) {
        List<Certificado> certificados= certificadoService.findAll(size, page, "id");

        model.addAttribute("tipoCertificados", CertificadoTipo.values());
        model.addAttribute("certificados", certificados);
        model.addAttribute("page", page);

        return "certificado/list";
    }

    @RequestMapping("show")
    public String show(@RequestParam Long id, Model model) {
        Certificado certificado= certificadoService.get(id);
        certificadoService.agregarImagenesALosCertificados(Arrays.asList(certificado));
        model.addAttribute("certificado", certificado);

        return "certificado/show";
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile){
        String returnValue = "";
        try {
            certificadoService.saveImage(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:list";
    }

    @RequestMapping("/search")
    public String findColaboradorByName(@RequestParam(defaultValue = "") String value, Model model) {
        model.addAttribute("certificados", certificadoService.findCertificadoByColaborador(value));
        return "certificado/list";
    }
}
