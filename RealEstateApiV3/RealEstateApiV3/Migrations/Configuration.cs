namespace RealEstateApiV3.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using RealEstateApiV3.Models;

    internal sealed class Configuration : DbMigrationsConfiguration<RealEstateApiV3.Models.RealEstateApiV3Context>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(RealEstateApiV3.Models.RealEstateApiV3Context context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //

            context.ClientModels.AddOrUpdate(p => p.Name,
               new ClientModel
               {
                   Name = "Debra Garcia",
                   Address = "1234 Main St",
                   City = "Redmond",
                   Country = "US",
                   Zip = "10999",
                   Email = "debra@example.com",
                   Phone = "+15345435355"
               },
                new ClientModel
                {
                    Name = "Thorsten Weinrich",
                    Address = "5678 1st Ave W",
                    City = "Redmond",
                    Country = "RU",
                    Zip = "10999",
                    Email = "thorsten@example.com",
                    Phone = "+72141414141"
                },
                new ClientModel
                {
                    Name = "Yuhong Li",
                    Address = "9012 State st",
                    City = "Redmond",
                    Country = "US",
                    Zip = "10999",
                    Email = "yuhong@example.com",
                    Phone = "+1323344444"
                },
                new ClientModel
                {
                    Name = "Jon Orton",
                    Address = "3456 Maple St",
                    City = "Redmond",
                    Country = "RU",
                    Zip = "10999",
                    Email = "jon@example.com",
                    Phone = "+7323243242"
                },
                new ClientModel
                {
                    Name = "Diliana Alexieva-Bosseva",
                    Address = "7890 2nd Ave E",
                    City = "Redmond",
                    Country = "US",
                    Zip = "10999",
                    Email = "diliana@example.com",
                    Phone = "+124242342342"
                }
            );
        }
    }
}
