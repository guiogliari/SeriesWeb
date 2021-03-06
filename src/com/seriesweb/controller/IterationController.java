package com.seriesweb.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.seriesweb.model.Iteration;

@Path("/Iteration")
public class IterationController extends AbstractFacade<Iteration>{

	@PersistenceContext(unitName = "SeriesWeb")
    private EntityManager em;

    public IterationController() {
        super(Iteration.class);
    }

    @POST
    @Override
    @Consumes("application/json")
    public void create(Iteration entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") String id, Iteration entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Iteration find(@PathParam("id") String id) {
        return super.find(Long.valueOf(id));
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Iteration> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Iteration> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
}
