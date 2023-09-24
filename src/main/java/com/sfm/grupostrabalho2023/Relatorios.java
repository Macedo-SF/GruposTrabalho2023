package com.sfm.grupostrabalho2023;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Transactional
@WebServlet(name = "Relatorios", urlPatterns = {"/Relatorios"})
public class Relatorios extends HttpServlet {

    @Inject
    private ConsultaServiceLocal consultaService;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PessoaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Estudo Dirigido: Jakarta Persistence Query Language</h1>");
            
            //<editor-fold defaultstate="collapsed" desc="Consulta 01">
            List<Pessoa> pl;
            
            out.println("<h2 style=\"color: red;\">     Q1 - Quais as pessoas (dados completos) cadastradas?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findAllPessoaQuerry();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");

            out.println("<h3 style=\"color: blue;\">Por meio de TypedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findAllPessoaTypedQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            
            out.println("<h3 style=\"color: blue;\">Por meio de NamedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findAllPessoaNamedQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 02">
            List<String> str; 
            
            out.println("<h2 style=\"color: red;\">     Q2 - Quais os nomes das pessoas? </h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            str = consultaService.findNomeQuery();
            for (String o : str) {
                out.println("<li style=\"color: green;\">" + o + "</li><br>");
            }
            out.println("</ul>");
            
            out.println("<h3 style=\"color: blue;\">Por meio de TypedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            str = consultaService.findNomeTypedQuery();
            for (String o : str) {
                out.println("<li style=\"color: green;\">" + o + "</li><br>");
            }
            out.println("</ul>");
            
            out.println("<h3 style=\"color: blue;\">Por meio de NamedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            str = consultaService.findNomeNamedQuery();
            for (String o : str) {
                out.println("<li style=\"color: green;\">" + o + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>
             
            //<editor-fold defaultstate="collapsed" desc="Consulta 03">
            
            List<Object[]> obQ3;
            
            out.println("<h2 style=\"color: red;\">     Q3 - Quais as pessoas (nome) e seus respectivos endereços (dados completos)? </h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ3 = consultaService.fiindNomeEnderecoQuery();
            
            for (Object[] o : obQ3) {
                
                out.println("<li style=\"color: green;\"> nome : " + o[0] + " endereco :  " + o[1] + "</li><br>");
            }
            out.println("</ul>");
            
            out.println("<h3 style=\"color: blue;\">Por meio de TypedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            obQ3 = consultaService.fiindNomeEnderecoTypedQuery();
            
            for (Object[] o : obQ3) {
                
                out.println("<li style=\"color: green;\"> nome : " + o[0] + " endereco :  " + o[1] + "</li><br>");
            }
            out.println("</ul>");
          
            
            out.println("<h3 style=\"color: blue;\">Por meio de NamedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            obQ3 = consultaService.fiindNomeEnderecoNamedQuery();
            
            for (Object[] o : obQ3) {
                
                out.println("<li style=\"color: green;\"> nome : " + o[0] + " endereco :  " + o[1] + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>
             
            //<editor-fold defaultstate="collapsed" desc="Consulta 04">
            
            out.println("<h2 style=\"color: red;\">     Q4 - Quais pessoas (dados completos) moram em avenidas?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findPessoaQueMoramEmAvenidaQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");

            out.println("<h3 style=\"color: blue;\">Por meio de TypedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findPessoaQueMoramEmAvenidaTypedQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            
            out.println("<h3 style=\"color: blue;\">Por meio de NamedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findPessoaQueMoramEmAvenidaNamedQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>
    
            //<editor-fold defaultstate="collapsed" desc="Consulta 05">
            
            out.println("<h2 style=\"color: red;\">     Q5 - Quais pessoas (dados completos) não moram em praças?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findPessoasQueNaoMoramEmPracaQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");

            out.println("<h3 style=\"color: blue;\">Por meio de TypedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findPessoasQueNaoMoramEmPracaTypedQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            
            out.println("<h3 style=\"color: blue;\">Por meio de NamedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.findPessoasQueNaoMoramEmPracaNamedQuery();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>
              
            //<editor-fold defaultstate="collapsed" desc="Consulta 06">
            
            List<Object[]> obQ6;
            
            out.println("<h2 style=\"color: red;\">     Q6 - Quais os nomes das pessoas e seus respectivos telefones (dados completos)? </h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ6 = consultaService.findNomeTelefoneQuery();
            
            for (Object[] o : obQ6) {
                
                out.println("<li style=\"color: green;\"> nome : " + o[0] + " Telefone : " + o[1] + " </li><br>");
            }
            out.println("</ul>");
            
            out.println("<h3 style=\"color: blue;\">Por meio de TypedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            obQ6 = consultaService.findNomeTelefoneTypedQuery();
            
            for (Object[] o : obQ6) {
                
                out.println("<li style=\"color: green;\"> nome : " + o[0] + " Telefone : " + o[1] + " </li><br>");
            }
            out.println("</ul>");
          
            
            out.println("<h3 style=\"color: blue;\">Por meio de NamedQuery </h>");
            out.println("<ul style=\"color: green;\">");
            obQ6 = consultaService.findNomeTelefoneNamedQuery();
            
            for (Object[] o : obQ6) {
                
                out.println("<li style=\"color: green;\"> nome : " + o[0] + " Telefone : " + o[1] + " </li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 07">
            out.println("<h2 style=\"color: red;\">     Q7 - Quais as pessoas (dados completos) que nasceram entre abril de 2001 e abril de 2004?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.consulta7(LocalDate.of(2001, Month.APRIL, 1), LocalDate.of(2004, Month.APRIL, 30));
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 08">
            // Consulta 8: Quais pessoas (dados completos) têm telefone do estado do Paraná e Rio de Janeiro?
            out.println("<h2 style=\"color: red;\">     Q8 - Quais pessoas (dados completos) têm telefone do estado do Paraná e Rio de Janeiro?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query</h>");
            out.println("<ul style=\"color: green;\">");

            pl = consultaService.consulta8();

            if (pl.isEmpty()) {
                out.println("<li style=\"color: green;\">Ninguém tem esses números...</li><br>");
            }
            else {
                for (Pessoa p : pl) {
                    out.println("<li style=\"color: green;\">" + p + "</li><br>");
                }
            }

            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 09">
            out.println("<h2 style=\"color: red;\">     Q9 - Quais pessoas (dados completos) não possuem telefone?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            pl = consultaService.consulta9();
            for (Pessoa p : pl) {
                out.println("<li style=\"color: green;\">" + p + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 10">
            List<Object[]> obQ10;
            
            out.println("<h2 style=\"color: red;\">     Q10 - Quantos telefones cada pessoa (nome) tem?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ10 = consultaService.consulta10();
            for (Object[] o : obQ10) {
                out.println("<li style=\"color: green;\">" + o[0] +" ---> : " +o[1] + " telefones </li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 11">
            List<Grupo> gl;
            
            out.println("<h2 style=\"color: red;\">     Q11 - Quais grupos (dados completos) não estão ativos?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            gl = consultaService.findGruposNaoAtivos();
            for (Grupo g : gl) {
                out.println("<li style=\"color: green;\">" + g + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 12">
            List<Object[]> obQ12;
            
            out.println("<h2 style=\"color: red;\">     Q12 - Quais são os líderes (nomes) dos grupos (nomes)? </h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ12 = consultaService.findLiderENomeGrupo();
            for (Object[] o : obQ12) {
                out.println("<li style=\"color: green;\"> Grupo : " + o[0] + " , Lider : "+ o[1] +"</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>
 
            //<editor-fold defaultstate="collapsed" desc="Consulta 13">
            out.println("<h2 style=\"color: red;\">     Q13 - Quais são os membros (nomes) do grupo com nome \"Estudo IV\" com ordenação alfabética inversa?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            str = consultaService.consulta13("Estudo IV");
            for (String s : str) {
                out.println("<li style=\"color: green;\">" + s + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 14">
            out.println("<h2 style=\"color: red;\">     Q14 - Quais são os grupos (dados completos) liderados por \"Beatriz Yana\"?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            gl = consultaService.consulta14("Beatriz Yana");
            for (Grupo g : gl) {
                out.println("<li style=\"color: green;\">" + g + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 15">
            List<Object[]> obQ15;
            
            out.println("<h2 style=\"color: red;\">     Q15 - Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais \"Cecília Xerxes\" é membro?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ15 = consultaService.consulta15("Cecília Xerxes");
            for (Object[] o : obQ15) {
                out.println("<li style=\"color: green;\"> Grupo : " + o[0] + " , Inicio : "+ o[1] +" , Termino : " +o[2]+ "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 16">
            out.println("<h2 style=\"color: red;\">     Q16 - Quais são os grupos (dados completos) que contêm \"II\" em seus nomes?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            gl = consultaService.consulta16("II");
            for (Grupo g : gl) {
                out.println("<li style=\"color: green;\">" + g + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 17">
            List<Object[]> obQ17;
            
            out.println("<h2 style=\"color: red;\">     Q17 - Quais são os grupos (nomes) e os respectivos totais de membros distintos já alocados?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ17 = consultaService.consulta17();
            for (Object[] o : obQ17) {
                out.println("<li style=\"color: green;\"> Grupo : " + o[0] + " ---> : "+ o[1] +" membros</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 18">
            List<Object[]> obQ18;
            
            out.println("<h2 style=\"color: red;\">     Q18 - Quais grupos (nomes) têm 3 ou mais atuações de membros e quanto são esses totais de atuações?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ18 = consultaService.consulta18(3L);
            for (Object[] o : obQ18) {
                out.println("<li style=\"color: green;\"> Grupo : " + o[0] + " ---> : "+ o[1] +" atuações totais</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 19">
            
            
            out.println("<h2 style=\"color: red;\">     Q19 - Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            str = consultaService.consulta19("Estudo I", LocalDate.of(2012, Month.JANUARY, 1));
            for (String s : str) {
                out.println("<li style=\"color: green;\">" + s + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 20">
            List<Object[]> obQ20;
            
            out.println("<h2 style=\"color: red;\">     Q20 - Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que entraram a partir de 2012 em qualquer grupo?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ20 = consultaService.consulta20(LocalDate.of(2012, Month.JANUARY, 1));
            for (Object[] o : obQ20) {
                out.println("<li style=\"color: green;\"> Grupo : " + o[0] + " ---> Membro : "+ o[1] +" , ingressou : " +o[2]+ "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 21">
            List<Object[]> obQ21;
            
            out.println("<h2 style=\"color: red;\">     Q21 - Quais os grupos (nomes) e respectivos membros (nomes) que não possuem data de término de atuação em seus grupos?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ21 = consultaService.consulta21();
            for (Object[] o : obQ21) {
                out.println("<li style=\"color: green;\"> Grupo : " + o[0] + " ---> Membro : "+ o[1] +"</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Consulta 22">
            List<Object[]> obQ22;
            
            out.println("<h2 style=\"color: red;\">     Q22 - Quais são os grupos (nomes) e líderes (nomes) com respectivos membros(nomes)?</h>");
            out.println("<h3 style=\"color: blue;\">Por meio de Query </h>");
            out.println("<ul style=\"color: green;\">");
            obQ22 = consultaService.consulta22();
            for (Object[] o : obQ22) {
                out.println("<li style=\"color: green;\"> Grupo : " + o[0] + " ---> Lider : "+ o[1] +" , ---> Mebro : "+ o[2] + "</li><br>");
            }
            out.println("</ul>");
            //</editor-fold>

            out.println("</body>");
            out.println("</html>");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}