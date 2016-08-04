namespace RealEstateApi.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<RealEstateApi.ReadlEstateDbContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(RealEstateApi.ReadlEstateDbContext context)
        {
            context.Clients.AddOrUpdate(x => x.Id, 
                new ClientModel { Id = 1, about = "Some guy", fio = "One two three", phone = "123-456" },
                new ClientModel { Id = 2, about = "Другой какой-то чувак", fio = "Раз два три", phone = "321-654"});
        }
    }
}
