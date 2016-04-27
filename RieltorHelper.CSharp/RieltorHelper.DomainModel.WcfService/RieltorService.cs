using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using RieltorHelper.Infrastructure;
using RieltorHelper.DomainModel;

namespace RieltorHelper.DomainModel.WcfService
{
    // ПРИМЕЧАНИЕ. Команду "Переименовать" в меню "Рефакторинг" можно использовать для одновременного изменения имени класса "Service1" в коде и файле конфигурации.
    public class RieltorHelperService : IRieltorService
    {
        IRieltorRepository bdRepo;
        public RieltorHelperService()
        {
            bdRepo = new SQLiteRieltorRepository();
        }

        #region IRieltorService implementation

        #endregion

    }
}
