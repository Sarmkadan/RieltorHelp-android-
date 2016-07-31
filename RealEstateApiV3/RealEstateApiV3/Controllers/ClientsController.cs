using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using RealEstateApiV3.Models;

namespace RealEstateApiV3.Controllers
{
    public class ClientsController : ApiController
    {
        private RealEstateApiV3Context db = new RealEstateApiV3Context();

        // GET: api/Clients
        public IQueryable<ClientModel> GetClientModels()
        {
            return db.ClientModels;
        }

        // GET: api/Clients/5
        [ResponseType(typeof(ClientModel))]
        public IHttpActionResult GetClientModel(int id)
        {
            ClientModel clientModel = db.ClientModels.Find(id);
            if (clientModel == null)
            {
                return NotFound();
            }

            return Ok(clientModel);
        }

        // PUT: api/Clients/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutClientModel(int id, ClientModel clientModel)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != clientModel.Id)
            {
                return BadRequest();
            }

            db.Entry(clientModel).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ClientModelExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Clients
        [ResponseType(typeof(ClientModel))]
        public IHttpActionResult PostClientModel(ClientModel clientModel)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.ClientModels.Add(clientModel);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = clientModel.Id }, clientModel);
        }

        // DELETE: api/Clients/5
        [ResponseType(typeof(ClientModel))]
        public IHttpActionResult DeleteClientModel(int id)
        {
            ClientModel clientModel = db.ClientModels.Find(id);
            if (clientModel == null)
            {
                return NotFound();
            }

            db.ClientModels.Remove(clientModel);
            db.SaveChanges();

            return Ok(clientModel);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool ClientModelExists(int id)
        {
            return db.ClientModels.Count(e => e.Id == id) > 0;
        }
    }
}