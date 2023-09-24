package com.sfm.grupostrabalho2023;


import java.time.LocalDate;
import java.time.Month;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class CargaDados implements CargaDadosLocal {

    @Inject
    private ConsultaServiceLocal consultaService;

    
    
    @PostConstruct
    @Override
    public void popularBanco() {

        //<editor-fold defaultstate="collapsed" desc="Ana Zaira (p1)">
        Telefone t1 = new Telefone();
        t1.setDdd((byte) 11);
        t1.setNumero(11111111);

        Telefone t2 = new Telefone();
        t2.setDdd((byte) 12);
        t2.setNumero(12121212);

        Telefone t3 = new Telefone();
        t3.setDdd((byte) 13);
        t3.setNumero(13131313);

        Endereco e1 = new Endereco();
        e1.setLogradouro("1");
        e1.setBairro("Humberto");
        e1.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
        e1.setNumero(1111);

        Pessoa p1 = new Pessoa();
        p1.setNome("Ana Zaira");
        p1.setEmail("ana@mail.com");
        p1.setNascimento(LocalDate.of(2001, Month.JANUARY, 1));
        p1.setEndereco(e1);
        p1.getTelefones().add(t1);
        p1.getTelefones().add(t2);
        p1.getTelefones().add(t3);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Beatriz Yana (p2)">
        Telefone t4 = new Telefone();
        t4.setDdd((byte) 22);
        t4.setNumero(22222222);

        Endereco e2 = new Endereco();
        e2.setLogradouro("2");
        e2.setBairro("Doisberto");
        e2.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);
        e2.setNumero(2222);

        Pessoa p2 = new Pessoa();
        p2.setNome("Beatriz Yana");
        p2.setEmail("beatriz@mail.com");
        p2.setNascimento(LocalDate.of(2002, Month.FEBRUARY, 2));
        p2.setEndereco(e2);
        p2.getTelefones().add(t4);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Cecília Xerxes (p3)">
        Endereco e3 = new Endereco();
        e3.setLogradouro("3");
        e3.setBairro("Trêsberto");
        e3.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);
        e3.setNumero(3333);

        Pessoa p3 = new Pessoa();
        p3.setNome("Cecília Xerxes");
        p3.setEmail("cecilia@mail.com");
        p3.setNascimento(LocalDate.of(2003, Month.MARCH, 3));
        p3.setEndereco(e3);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Débora Wendel (p4)">
        Telefone t5 = new Telefone();
        t5.setDdd((byte) 44);
        t5.setNumero(44444444);

        Telefone t6 = new Telefone();
        t6.setDdd((byte) 45);
        t6.setNumero(45454545);

        Endereco e4 = new Endereco();
        e4.setLogradouro("4");
        e4.setBairro("Quatroberto");
        e4.setTipoLogradouro(Endereco.TipoLogradouro.PRACA);
        e4.setNumero(4444);

        Pessoa p4 = new Pessoa();
        p4.setNome("Débora Wendel");
        p4.setEmail("debora@mail.com");
        p4.setNascimento(LocalDate.of(2004, Month.APRIL, 4));
        p4.setEndereco(e4);
        p4.getTelefones().add(t5);
        p4.getTelefones().add(t6);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Estudo I">
        Grupo g1 = new Grupo();
        g1.setAtivo(false);
        g1.setNome("Estudo I");
        g1.setLider(p1);

        Atuacao a1 = new Atuacao();
        a1.setInicio(LocalDate.of(2011, Month.JANUARY, 1));
        a1.setTermino(LocalDate.of(2021, Month.NOVEMBER, 11));
        a1.setGrupo(g1);
        a1.setPessoa(p1);

        p1.getAtuacoes().add(a1);
        g1.getAtuacoes().add(a1);

        Atuacao a = new Atuacao();
        a.setInicio(LocalDate.of(2012, Month.JANUARY, 1));
        a.setTermino(LocalDate.of(2022, Month.NOVEMBER, 11));
        a.setGrupo(g1);
        a.setPessoa(p1);

        p1.getAtuacoes().add(a);
        g1.getAtuacoes().add(a);

        Atuacao a2 = new Atuacao();
        a2.setInicio(LocalDate.of(2012, Month.JANUARY, 2));
        a2.setTermino(LocalDate.of(2021, Month.JANUARY, 12));
        a2.setGrupo(g1);
        a2.setPessoa(p2);

        p2.getAtuacoes().add(a2);
        g1.getAtuacoes().add(a2);

        Atuacao a3 = new Atuacao();
        a3.setInicio(LocalDate.of(2013, Month.JANUARY, 3));
        a3.setTermino(LocalDate.of(2021, Month.JANUARY, 13));
        a3.setGrupo(g1);
        a3.setPessoa(p3);

        p3.getAtuacoes().add(a3);
        g1.getAtuacoes().add(a3);

        Atuacao a4 = new Atuacao();
        a4.setInicio(LocalDate.of(2014, Month.JANUARY, 4));
        a4.setTermino(LocalDate.of(2021, Month.JANUARY, 14));
        a4.setGrupo(g1);
        a4.setPessoa(p4);

        p4.getAtuacoes().add(a4);
        g1.getAtuacoes().add(a4);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Estudo II">
        Grupo g2 = new Grupo();
        g2.setAtivo(true);
        g2.setNome("Estudo II");
        g2.setLider(p2);

        Atuacao a5 = new Atuacao();
        a5.setInicio(LocalDate.of(2012, Month.JANUARY, 2));
        a5.setGrupo(g2);
        a5.setPessoa(p2);

        p2.getAtuacoes().add(a5);
        g2.getAtuacoes().add(a5);

        Atuacao a6 = new Atuacao();
        a6.setInicio(LocalDate.of(2012, Month.JANUARY, 2));
        a6.setGrupo(g2);
        a6.setPessoa(p4);

        p4.getAtuacoes().add(a6);
        g2.getAtuacoes().add(a6);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Estudo III">
        Grupo g3 = new Grupo();
        g3.setAtivo(false);
        g3.setNome("Estudo III");
        g3.setLider(p3);

        Atuacao a7 = new Atuacao();
        a7.setInicio(LocalDate.of(2012, Month.JANUARY, 3));
        a7.setTermino(LocalDate.of(2023, Month.JANUARY, 13));
        a7.setGrupo(g3);
        a7.setPessoa(p3);

        p3.getAtuacoes().add(a7);
        g3.getAtuacoes().add(a7);

        Atuacao a8 = new Atuacao();
        a8.setInicio(LocalDate.of(2012, Month.JANUARY, 3));
        a8.setTermino(LocalDate.of(2023, Month.JANUARY, 13));
        a8.setGrupo(g3);
        a8.setPessoa(p4);

        p4.getAtuacoes().add(a8);
        g3.getAtuacoes().add(a8);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Estudo IV">
        Grupo g4 = new Grupo();
        g4.setAtivo(true);
        g4.setNome("Estudo IV");
        g4.setLider(p2);

        Atuacao a9 = new Atuacao();
        a9.setInicio(LocalDate.of(2012, Month.JANUARY, 4));
        a9.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
        a9.setGrupo(g4);
        a9.setPessoa(p2);

        p2.getAtuacoes().add(a9);
        g4.getAtuacoes().add(a9);

        Atuacao a10 = new Atuacao();
        a10.setInicio(LocalDate.of(2012, Month.JANUARY, 4));
        a10.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
        a10.setGrupo(g4);
        a10.setPessoa(p3);

        p3.getAtuacoes().add(a10);
        g4.getAtuacoes().add(a10);

        Atuacao a11 = new Atuacao();
        a11.setInicio(LocalDate.of(2012, Month.JANUARY, 4));
        a11.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
        a11.setGrupo(g4);
        a11.setPessoa(p4);

        p4.getAtuacoes().add(a11);
        g4.getAtuacoes().add(a11);
        //</editor-fold>

        p1.getLiderancas().add(g1);
        p2.getLiderancas().add(g2);
        p2.getLiderancas().add(g4);
        p3.getLiderancas().add(g3);

        consultaService.save(p1);
        consultaService.save(p2);
        consultaService.save(p3);
        consultaService.save(p4);
    }
}