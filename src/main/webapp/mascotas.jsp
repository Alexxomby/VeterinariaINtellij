<%--
    Document   : mascotas
    Created on : 2 jun 2023, 20:57:02
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Listado de Mascotas</title>
</head>
<body>
<h1>Listado de Mascotas</h1>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Propietario ID</th>
    <th>Raza ID</th>
    <th>Nacimiento</th>
    <th>Nombre</th>
    <th>Tamaño</th>
    <th>Peso</th>
    <th>Sexo</th>
  </tr>
  </thead>
  <tbody>
  <%@ page import="Modelo.Perro" %>
  <%@ page import="java.util.List" %>
  <%@ page import="java.text.SimpleDateFormat" %>
  <% List<Perro> mascotas = (List<Perro>) request.getAttribute("mascotas"); %>
  <% if (mascotas != null) { %>
  <% for (Perro mascota : mascotas) { %>
  <tr>
    <td><%= mascota.getId() %></td>
    <td><%= mascota.getPropietario_id() %></td>
    <td><%= mascota.getRaza_id() %></td>
    <td><%= new SimpleDateFormat("yyyy-MM-dd").format(mascota.getNacimiento()) %></td>
    <td><%= mascota.getNombre() %></td>
    <td><%= mascota.getTamano() %></td>
    <td><%= mascota.getPeso() %></td>
    <td><%= mascota.getSexo() %></td>
  </tr>
  <% } %>
  <% } else { %>
  <tr>
    <td colspan="8">No hay mascotas registradas</td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>

