using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace RealEstateApi
{
    public class ReadlEstateDbContext: DbContext
    {
        public ReadlEstateDbContext() : base("DefaultConnection")
        {

        }

        public DbSet<ClientModel> Clients { get; set; }
    }
}