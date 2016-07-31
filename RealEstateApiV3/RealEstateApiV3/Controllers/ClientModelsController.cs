using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using RealEstateApiV3.Models;

namespace RealEstateApiV3.Controllers
{
    public class ClientModelsController : Controller
    {
        private RealEstateApiV3Context db = new RealEstateApiV3Context();

        // GET: ClientModels
        public ActionResult Index()
        {
            return View(db.ClientModels.ToList());
        }

        // GET: ClientModels/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ClientModel clientModel = db.ClientModels.Find(id);
            if (clientModel == null)
            {
                return HttpNotFound();
            }
            return View(clientModel);
        }

        // GET: ClientModels/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ClientModels/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Name,Address,City,Country,Zip,Email,Phone,Notes")] ClientModel clientModel)
        {
            if (ModelState.IsValid)
            {
                db.ClientModels.Add(clientModel);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(clientModel);
        }

        // GET: ClientModels/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ClientModel clientModel = db.ClientModels.Find(id);
            if (clientModel == null)
            {
                return HttpNotFound();
            }
            return View(clientModel);
        }

        // POST: ClientModels/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Name,Address,City,Country,Zip,Email,Phone,Notes")] ClientModel clientModel)
        {
            if (ModelState.IsValid)
            {
                db.Entry(clientModel).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(clientModel);
        }

        // GET: ClientModels/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ClientModel clientModel = db.ClientModels.Find(id);
            if (clientModel == null)
            {
                return HttpNotFound();
            }
            return View(clientModel);
        }

        // POST: ClientModels/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ClientModel clientModel = db.ClientModels.Find(id);
            db.ClientModels.Remove(clientModel);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
