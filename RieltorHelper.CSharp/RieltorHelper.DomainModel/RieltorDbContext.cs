using System;
using System.Data.Entity;
using System.Collections.Generic;
using System.Linq;

namespace RieltorHelper.DomainModel
{
    public class RieltorDbContext: DbContext
    {
        /*
        Db Sets here
        as
        public DbSet<entity> Entities {get;set;}
        */
        public RieltorDbContext() : base("DefaultConnection")
        {
            //Database.SetInitializer<RieltorDbContext>(new DropCreateDatabaseAlways<RieltorDbContext>());
        }
        
        public DbSet<User> Users { get; set; }
    }
}