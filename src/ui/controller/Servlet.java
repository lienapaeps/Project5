package ui.controller;

import domain.db.FilmDB;
import domain.model.Film;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private FilmDB filmDB = new FilmDB();

    public Servlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String destination;

        String command = "home";
        if(request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        
        switch (command){
            case "overview" :
                destination = overview(request, response);
                break;
            case "add" :
                destination = add(request, response);
                break;
            case "delete" :
                destination = delete(request, response);
                break;
            case "deleteConfirmation":
                destination = deleteConfirmation(request, response);
                break;
            case "zoek":
                destination = zoek(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("langsteSpeelduur", filmDB.filmMetLangsteSpeelduur());
        return "index.jsp";
    }

    private String overview(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("alleFilms", filmDB.vindAlle());
        return "overzicht.jsp";
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String titel = request.getParameter("titel");
        String genre = request.getParameter("genre");
        String speelduur = request.getParameter("speelduur");
        String rating = request.getParameter("rating");

        String destination;

        if (titel.isEmpty() || genre.isEmpty() || speelduur.isEmpty() || rating.isEmpty()) {
            destination = "voegToe.jsp";
        }else {
            Film film = new Film(titel, genre, Integer.parseInt(speelduur), Integer.parseInt(rating));
            filmDB.voegToe(film);
            request.setAttribute("alleFilms", filmDB.vindAlle());
            request.setAttribute("langsteSpeelduur", filmDB.filmMetLangsteSpeelduur());
            destination = overview(request, response);
        }
        return destination;
    }

    private String delete(HttpServletRequest request, HttpServletResponse response) {
        return "deleteConfirmation.jsp";
    }

    private String deleteConfirmation(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("submit").equals("Zeker")){
            String titel = request.getParameter("titel");
            filmDB.verwijder(filmDB.vind(titel));
            return overview(request, response);
        }
        else {
            return home(request, response);
        }
    }
    private String zoek(HttpServletRequest request, HttpServletResponse response) {
        String titel = request.getParameter("titel");
        String destination = "";

        if (titel == null){
            destination = "nietGevonden.jsp";
        }else{
            Film film = filmDB.vind(titel);
            if (film == null){
                destination = "nietGevonden.jsp";
            }else {
                destination = "gevonden.jsp";
                request.setAttribute("film", film);
            }
        }
        return destination;
    }
}



