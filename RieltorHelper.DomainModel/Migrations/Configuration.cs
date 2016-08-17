namespace RieltorHelper.DomainModel.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<RieltorHelper.DomainModel.RieltorDbContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(RieltorHelper.DomainModel.RieltorDbContext context)
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
            context.Users.AddOrUpdate(
                    new User() { About = "A girl has no name", FIO = "Arya Stark", Phone="000" },
                    new User() { About = "PM", FIO= "sarmkadan", Phone="123" },
                    new User() { About ="Some dev", FIO="Kos Koskapan", Phone="2"},
                    new User() { About= "Yet another dev", FIO= "Wadim Rudkovski", Phone="3" }                    
                    );
        }
    }
}
