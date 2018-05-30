package com.venio.rest;

import com.venio.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/zadanie2")
public class FilmRest {

    private Session session;
    private final String restURI = "http://localhost:8080/filmREST-1.0-SNAPSHOT/zadanie2/filmy/";

    public FilmRest() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
        this.session.beginTransaction();
    }

    @GET
    @Path("/filmy/filtr")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmFiltr(@QueryParam("tytul") String tytul) {
        List<Film> filmy;
        if (tytul == null) {
            filmy = session.createQuery("FROM Film").list();
        } else {
            filmy = session.createQuery("FROM Film WHERE tytul LIKE '%" + tytul + "%'").list();
        }
        session.close();
        return Response.status(Response.Status.OK).entity(filmy).build();
    }

    @GET
    @Path("/filmy")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKoty() {
        List<Film> filmy = session.createQuery("FROM Film").list();
        session.close();
        return Response.status(Response.Status.OK).entity(filmy).build();
    }

    @GET
    @Path("/filmy/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmy(@PathParam("id") Integer id) {
        Film film = session.get(Film.class, id);
        if (film == null) {
            session.close();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        session.close();
        return Response.status(Response.Status.OK).entity(film).build();

    }

    @POST
    @Path("/filmy/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postFilm(List<Film> filmy) {
        for (Film film : filmy) {
            session.save(film);
            film.setUri(restURI + film.getId());
        }
        session.getTransaction().commit();
        session.close();
        return Response.status(Response.Status.OK).entity(filmy).build();
    }

    @DELETE
    @Path("/filmy/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFilm(@PathParam("id") Integer id) {
        Film film = session.get(Film.class, id);
        if (film == null) {
            session.close();
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        session.delete(film);
        session.getTransaction().commit();
        session.close();
        return Response.status(Response.Status.OK).entity(film).build();
    }

    @GET
    @Path("/uri-list")
    @Produces("text/uri-list")
    public Response getAllUri() {
        List<Film> filmy = session.createQuery("FROM Film").list();
        String lista = "";
        for (Film film : filmy) {
            lista += film.getUri() + "\n";
        }
        session.close();
        return Response.status(Response.Status.OK).entity(lista).build();
    }


}

