package com.ideaas.web.controller;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.domain.certificado.CertificadoTipo;
import com.ideaas.services.service.FileServiceImpl;
import com.ideaas.services.service.interfaces.CertificadoService;
import com.ideaas.services.service.interfaces.ColaboradorService;
import com.ideaas.services.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("certificado")
public class CertificadoController {

    private CertificadoService certificadoService;
    private ColaboradorService colaboradorService;
    private FileServiceImpl fileService;
    private UsuarioService userSercice;


    @Autowired
    public CertificadoController(CertificadoService certificadoService, ColaboradorService colaboradorService, FileServiceImpl fileService, UsuarioService userSercice) {
        this.certificadoService = certificadoService;
        this.colaboradorService = colaboradorService;
        this.fileService = fileService;
        this.userSercice = userSercice;
    }

    @RequestMapping(value = "save")
    public String save(Certificado certificado){
        certificadoService.save(certificado);

        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Long id, Model model) {
        Certificado certificado = certificadoService.getById(id);
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
        List<Certificado> certificados = certificadoService.findAll(size, page, "id");
        model.addAttribute("tipoCertificados", CertificadoTipo.values());
        model.addAttribute("certificados", certificados);
        model.addAttribute("page", page);

        return "certificado/list";
    }

//    @RequestMapping("show")
//    public String show(@RequestParam Long id, Model model) {
//        Certificado certificado= certificadoService.get(id);
//        certificadoService.agregarImagenesALosCertificados(Arrays.asList(certificado));
//        model.addAttribute("certificado", certificado.getId());
//
//        return "certificado/show";
//    }

    @RequestMapping("show")
    public String show(@RequestParam Long id, Model model) {
        Certificado certificado= certificadoService.getById(id);
        certificadoService.agregarImagenesALosCertificados(Arrays.asList(certificado));
        model.addAttribute("certificado", certificado);

        return "certificado/show";
    }

    @RequestMapping("deleteById")
    public String deleteById(@RequestParam Long id){
        certificadoService.deleteById(id);
        return "redirect:list";
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
        model.addAttribute("data", certificadoService.getCantidadDeCertificadosPorMes());

        return "certificado/list";
    }

    @RequestMapping("/buscarColaboradorPorFecha")
    public String buscarColaboradorPorFecha(@RequestParam(required = false) String fechaInicio, @RequestParam(required = false) String fechaFin, Model model){
        LocalDate inicioParse = LocalDate.parse(fechaInicio);
        LocalDate finParse = LocalDate.parse(fechaFin);

        model.addAttribute("findByAusentismoColaborador", certificadoService.buscarEstadisticasPorFecha(inicioParse, finParse).stream().sorted(Comparator.comparing(Certificado::getAusentismo)).collect( Collectors.groupingBy( Certificado::getColaborador, Collectors.summingInt(Certificado::getAusentismo))));
        model.addAttribute("findByAusentismoEnero", certificadoService.findByAusentismoEnero());
        model.addAttribute("findByAusentismoFebrero", certificadoService.findByAusentismoFebrero());
        model.addAttribute("findByAusentismoMarzo", certificadoService.findByAusentismoMarzo());
        model.addAttribute("findByAusentismoAbril", certificadoService.findByAusentismoAbril());
        model.addAttribute("findByAusentismoMayo", certificadoService.findByAusentismoMayo());
        model.addAttribute("findByAusentismoJunio", certificadoService.findByAusentismoJunio());
        model.addAttribute("findByAusentismoJulio", certificadoService.findByAusentismoJulio());
        model.addAttribute("findByAusentismoAgosto", certificadoService.findByAusentismoAgosto());
        model.addAttribute("findByAusentismoSeptiembre", certificadoService.findByAusentismoSeptiembre());
        model.addAttribute("findByAusentismoOctubre", certificadoService.findByAusentismoOctubre());
        model.addAttribute("findByAusentismoNoviembre", certificadoService.findByAusentismoNoviembre());
        model.addAttribute("findByAusentismoDiciembre", certificadoService.findByAusentismoDiciembre());
        model.addAttribute("findByAusentismoFechaActual", certificadoService.findByAusentismoFechaActual());
        model.addAttribute("findByAusentismoAnioActual", certificadoService.findByAusentismoAnioActual());
        model.addAttribute("data", certificadoService.getCantidadDeCertificadosPorMes());


        return "certificado/stats";
    }

    @RequestMapping("/buscarSucursalPorFecha")
    public String buscarSucursalPorFecha(@RequestParam(required = false) String fechaInicio, @RequestParam(required = false) String fechaFin, Model model){
        LocalDate inicioParse = LocalDate.parse(fechaInicio);
        LocalDate finParse = LocalDate.parse(fechaFin);

        model.addAttribute("findByAusentismoSucursal", certificadoService.buscarEstadisticasPorFecha(inicioParse, finParse).stream().sorted(Comparator.comparing(Certificado::getAusentismo)).collect( Collectors.groupingBy( object -> object.getColaborador().getSucursal(), Collectors.summingInt(Certificado::getAusentismo))));
        model.addAttribute("findByAusentismoEnero", certificadoService.findByAusentismoEnero());
        model.addAttribute("findByAusentismoFebrero", certificadoService.findByAusentismoFebrero());
        model.addAttribute("findByAusentismoMarzo", certificadoService.findByAusentismoMarzo());
        model.addAttribute("findByAusentismoAbril", certificadoService.findByAusentismoAbril());
        model.addAttribute("findByAusentismoMayo", certificadoService.findByAusentismoMayo());
        model.addAttribute("findByAusentismoJunio", certificadoService.findByAusentismoJunio());
        model.addAttribute("findByAusentismoJulio", certificadoService.findByAusentismoJulio());
        model.addAttribute("findByAusentismoAgosto", certificadoService.findByAusentismoAgosto());
        model.addAttribute("findByAusentismoSeptiembre", certificadoService.findByAusentismoSeptiembre());
        model.addAttribute("findByAusentismoOctubre", certificadoService.findByAusentismoOctubre());
        model.addAttribute("findByAusentismoNoviembre", certificadoService.findByAusentismoNoviembre());
        model.addAttribute("findByAusentismoDiciembre", certificadoService.findByAusentismoDiciembre());
        model.addAttribute("findByAusentismoFechaActual", certificadoService.findByAusentismoFechaActual());
        model.addAttribute("findByAusentismoAnioActual", certificadoService.findByAusentismoAnioActual());
        return "certificado/stats";
    }

    @RequestMapping("/buscarMotivoPorFecha")
    public String buscarMotivoPorFecha(@RequestParam(required = false) String fechaInicio, @RequestParam(required = false) String fechaFin, Model model){
        LocalDate inicioParse = LocalDate.parse(fechaInicio);
        LocalDate finParse = LocalDate.parse(fechaFin);

        model.addAttribute("findByAusentismoMotivo", certificadoService.buscarEstadisticasPorFecha(inicioParse, finParse).stream().sorted(Comparator.comparing(Certificado::getAusentismo)).collect( Collectors.groupingBy(object -> object.getTipoCertificado(), Collectors.summingInt(Certificado::getAusentismo))));
        model.addAttribute("findByAusentismoEnero", certificadoService.findByAusentismoEnero());
        model.addAttribute("findByAusentismoFebrero", certificadoService.findByAusentismoFebrero());
        model.addAttribute("findByAusentismoMarzo", certificadoService.findByAusentismoMarzo());
        model.addAttribute("findByAusentismoAbril", certificadoService.findByAusentismoAbril());
        model.addAttribute("findByAusentismoMayo", certificadoService.findByAusentismoMayo());
        model.addAttribute("findByAusentismoJunio", certificadoService.findByAusentismoJunio());
        model.addAttribute("findByAusentismoJulio", certificadoService.findByAusentismoJulio());
        model.addAttribute("findByAusentismoAgosto", certificadoService.findByAusentismoAgosto());
        model.addAttribute("findByAusentismoSeptiembre", certificadoService.findByAusentismoSeptiembre());
        model.addAttribute("findByAusentismoOctubre", certificadoService.findByAusentismoOctubre());
        model.addAttribute("findByAusentismoNoviembre", certificadoService.findByAusentismoNoviembre());
        model.addAttribute("findByAusentismoDiciembre", certificadoService.findByAusentismoDiciembre());
        model.addAttribute("findByAusentismoFechaActual", certificadoService.findByAusentismoFechaActual());
        model.addAttribute("findByAusentismoAnioActual", certificadoService.findByAusentismoAnioActual());
        return "certificado/stats";
    }

    @RequestMapping(value = {"/stats" , ""})
    public String estadisticaCertificado(Model model, @ModelAttribute("certificado") Certificado certificado) {
        List<Certificado> certificados= certificadoService.findAll();
        model.addAttribute("colaboradores", certificados);
        model.addAttribute("findByAusentismoEnero", certificadoService.findByAusentismoEnero());
        model.addAttribute("findByAusentismoFebrero", certificadoService.findByAusentismoFebrero());
        model.addAttribute("findByAusentismoMarzo", certificadoService.findByAusentismoMarzo());
        model.addAttribute("findByAusentismoAbril", certificadoService.findByAusentismoAbril());
        model.addAttribute("findByAusentismoMayo", certificadoService.findByAusentismoMayo());
        model.addAttribute("findByAusentismoJunio", certificadoService.findByAusentismoJunio());
        model.addAttribute("findByAusentismoJulio", certificadoService.findByAusentismoJulio());
        model.addAttribute("findByAusentismoAgosto", certificadoService.findByAusentismoAgosto());
        model.addAttribute("findByAusentismoSeptiembre", certificadoService.findByAusentismoSeptiembre());
        model.addAttribute("findByAusentismoOctubre", certificadoService.findByAusentismoOctubre());
        model.addAttribute("findByAusentismoNoviembre", certificadoService.findByAusentismoNoviembre());
        model.addAttribute("findByAusentismoDiciembre", certificadoService.findByAusentismoDiciembre());
        model.addAttribute("findByAusentismoFechaActual", certificadoService.findByAusentismoFechaActual());
        model.addAttribute("findByAusentismoAnioActual", certificadoService.findByAusentismoAnioActual());
        model.addAttribute("findByAusentismoPrueba",certificados.stream().collect(Collectors.groupingBy(object -> object.getFechaInicio().getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "AR")),Collectors.summingInt(Certificado::getAusentismo))));
        model.addAttribute("data", certificadoService.getCantidadDeCertificadosPorMes());
        model.addAttribute("findByAusentismoSucursal", certificados.stream().sorted(Comparator.comparing(Certificado::getAusentismo)).collect( Collectors.groupingBy( object -> object.getColaborador().getSucursal(), Collectors.summingInt(Certificado::getAusentismo))));
        model.addAttribute("findByAusentismoMotivo", certificados.stream().sorted(Comparator.comparing(Certificado::getAusentismo)).collect( Collectors.groupingBy(object -> object.getTipoCertificado(), Collectors.summingInt(Certificado::getAusentismo))));
        return "certificado/stats";
    }
}
