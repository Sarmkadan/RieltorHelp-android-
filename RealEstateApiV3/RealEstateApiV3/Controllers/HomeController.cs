using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace RealEstateApiV3.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            ViewBag.Title = "Real Estate API";
            return View();
        }

        public ActionResult Examples()
        {
            return View();
        }

        public ActionResult Error()
        {
            return View();
        }
    }
}