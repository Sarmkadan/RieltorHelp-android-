using System.Web;
using System.Web.Mvc;

namespace RieltorHelper.IdentityWebApp
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
