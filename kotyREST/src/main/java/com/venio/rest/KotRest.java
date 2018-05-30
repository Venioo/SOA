package com.venio.rest;

import com.venio.entity.Kot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/zadanie1")
public class KotRest {

    private Session session;

    public KotRest() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
        this.session.beginTransaction();
    }

    @GET
    @Path("/koty")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKoty() {
        List<Kot> koty = session.createQuery("FROM Kot").list();
        session.close();
        return Response.status(Response.Status.OK).entity(koty).build();
    }

    @GET
    @Path("/koty/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKot(@PathParam("id") Integer id) {
        Kot kot = session.get(Kot.class, id);
        if (kot == null) {
            session.close();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        session.close();
        return Response.status(Response.Status.OK).entity(kot).build();


    }

    @PUT
    @Path("/koty/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putKot(@PathParam("id") Integer id, Kot kot) {
        Kot nowyKot = session.get(Kot.class, id);
        if (nowyKot == null) {
            session.close();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        nowyKot.setRasa(kot.getRasa());
        nowyKot.setImie(kot.getImie());
        session.save(nowyKot);
        session.getTransaction().commit();
        session.close();
        return Response.status(Response.Status.OK).entity(nowyKot).build();
    }

    @DELETE
    @Path("/koty/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteKot(@PathParam("id") Integer id) {
        Kot kot = session.get(Kot.class, id);
        if (kot == null) {
            session.close();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        session.delete(kot);
        session.getTransaction().commit();
        session.close();
        return Response.status(Response.Status.OK).entity(kot).build();
    }

    @POST
    @Path("/koty/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postKot(List<Kot> koty) {
        //session.createQuery("delete from Kot").executeUpdate();
        for (Kot kot : koty) {
            session.save(kot);
        }
        session.getTransaction().commit();
        session.close();
        return Response.status(Response.Status.OK).entity(koty).build();
    }
}
