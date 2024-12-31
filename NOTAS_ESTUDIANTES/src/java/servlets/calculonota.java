/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * Desarrollado por Jeimmy Acosta Vargas, Cristina Vera e Ivan David Caro 
 */

@WebServlet(name = "calculonota", urlPatterns = {"/calculonota"})
public class calculonota extends HttpServlet {
/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
float periodo1, periodo2, periodo3; 
public void init(ServletConfig config) throws ServletException { 
super.init(config);
periodo1 = 35; 
periodo2 = 35; 
periodo3 = 30; 
} 
protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException { 
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) { 
        float notaperiodo1 = Float.parseFloat(request.getParameter("notaperiodo1"));
        float notaperiodo2 = Float.parseFloat(request.getParameter("notaperiodo2")); 
        float notaperiodo3 = Float.parseFloat(request.getParameter("notaperiodo3")); 
        float parcialperiodo1 = notaperiodo1 * (periodo1 / 100); 
        float parcialperiodo2 = notaperiodo2 * (periodo2 / 100); 
        float parcialperiodo3 = notaperiodo3 * (periodo3 / 100); 
        float notafinal = parcialperiodo1 + parcialperiodo2 + parcialperiodo3; 
        String nombre = request.getParameter("nombrealumno"); 
        String materia = request.getParameter("nombremateria"); 

// Validador de nota 
String concepto; 
if (notafinal >= 3) { 
concepto = "El Alumno ha aprobado la materia";
} else { 
concepto = "El Alumno NO ha aprobado la materia"; 
} 

out.println("<!doctype html>"); 
out.println("<html lang='en'>"); 
out.println("<head>"); 
out.println("<meta charset='utf-8'>"); 
out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>"); 
out.println("<title>Calcular Nota Final</title>"); 
out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>"); 
out.println("</head>"); 
out.println("<body>"); 
out.println("<div class='container mt-5'>"); 
out.println("<h1 class='mb-4'>Resultado del Cálculo de la Nota Final</h1>"); 
out.println("<table class='table table-striped'>"); 
out.println("<thead>"); 
out.println("<tr>");
out.println("<th scope='col'>Descripción</th>"); 
out.println("<th scope='col'>Valor</th>"); 
out.println("</tr>"); 
out.println("</thead>"); 
out.println("<tbody>"); 
out.println("<tr>"); 
out.println("<td>Nombre del Alumno</td>"); 
out.println("<td>" + nombre + "</td>"); 
out.println("</tr>"); 
out.println("<tr>");
out.println("<td>Nombre de la Materia</td>"); 
out.println("<td>" + materia + "</td>"); 
out.println("</tr>"); 
out.println("<tr>"); 
out.println("<td>Nota Periodo 1 35%</td>"); 
out.println("<td>" + notaperiodo1 + "</td>"); 
out.println("</tr>"); 
out.println("<tr>"); 
out.println("<td>Nota Periodo 2 35%</td>"); 
out.println("<td>" + notaperiodo2 + "</td>"); 
out.println("</tr>"); 
out.println("<tr>"); 
out.println("<td>Nota Periodo 3 30%</td>"); 
out.println("<td>" + notaperiodo3 + "</td>"); 
out.println("</tr>"); 
out.println("<tr>"); 
out.println("<td>Nota Final</td>"); 
out.println("<td>" + notafinal + "</td>"); 
out.println("</tr>"); 
out.println("<tr>"); 
out.println("<td>Concepto de Aprobación</td>"); 
out.println("<td>" + concepto + "</td>"); 
out.println("</tr>");
out.println("</tbody>"); 
out.println("</table>"); 
out.println("</div>"); 
out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js' integrity='sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz' crossorigin='anonymous'></script>"); 
out.println("</body>"); 
out.println("</html>"); 
} 
} 
@Override 
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
processRequest(request, response); 
} 
@Override 
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
processRequest(request, response); 
} 
@Override 
public String getServletInfo() { 
return "Short description"; 
} 
}
