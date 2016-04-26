--
-- Файл сгенерирован с помощью SQLiteStudio v3.0.7 в Чт апр 21 19:33:38 2016
--
-- Использованная кодировка текста: windows-1251
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Таблица: ArendImage
CREATE TABLE ArendImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, ArendID INTEGER REFERENCES Arend (ID) ON DELETE CASCADE);

-- Таблица: ArendRoom
CREATE TABLE ArendRoom (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING (0, 30), fullName STRING, date STRING, typeOfRent STRING, numOfRooms STRING, district STRING, addresses STRING, floor STRING, square STRING, condition STRING, heating STRING, furniture STRING, furnitureList STRING, householdAppliances STRING, householdAppliancesList STRING, typeSettle STRING, typeOfRoom STRING, forWhom STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: EarthSellImage
CREATE TABLE EarthSellImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, EarthSellID INTEGER REFERENCES EarthSell (ID) ON DELETE CASCADE);

-- Таблица: KVsell
CREATE TABLE KVsell (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING, district STRING, addresses STRING, numOfRooms STRING, numOfFloors STRING, rentOrSell STRING, typeOfHouse STRING, fullSquare STRING, livingSquare STRING, kitchenSquare STRING, heating STRING, conditionalApartment STRING, furniture STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: ArendPrimImage
CREATE TABLE ArendPrimImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, ArendPrimID INTEGER REFERENCES ArendPrim (ID) ON DELETE CASCADE);

-- Таблица: PrimSellImage
CREATE TABLE PrimSellImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, PrimSellID INTEGER REFERENCES PrimSell (ID) ON DELETE CASCADE);

-- Таблица: ArendRoomImage
CREATE TABLE ArendRoomImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, ArendRoomID INTEGER REFERENCES ArendRoom (ID) ON DELETE CASCADE);

-- Таблица: Arend
CREATE TABLE Arend (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING, numOfRooms STRING, typeOfObject STRING, district STRING, addresses STRING, floor STRING, square STRING, condition STRING, heating STRING, furniture STRING, furnitureList STRING, householdAppliances STRING, householdAppliancesList STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: HostelSell
CREATE TABLE HostelSell (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING, district STRING, addresses STRING, systemHostel STRING, numOfFloors STRING, typeOfHouse STRING, fullSquare STRING, condition STRING, heating STRING, havingFurniture STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: KVsellImage
CREATE TABLE KVsellImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, KVsellID INTEGER REFERENCES KVsell (ID) ON DELETE CASCADE);

-- Таблица: EarthSell
CREATE TABLE EarthSell (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING, cytyDistrict STRING, addresses STRING, distanceToCity INTEGER, fullSquare STRING, communicationsList STRING, docs STRING, docList STRING, outbuildings STRING, buildingsList STRING, typeOfArea STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: ArendPrim
CREATE TABLE ArendPrim (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING, district STRING, addresses STRING, rentOrSell STRING, kindOfRoom STRING, typeOfObject STRING, location STRING, numOfRooms STRING, square STRING, numOfRooms STRING, condition STRING, heating STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: HostelSellImage
CREATE TABLE HostelSellImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, HostelSellID INTEGER REFERENCES HostelSell (ID) ON DELETE CASCADE);

-- Таблица: PrimSell
CREATE TABLE PrimSell (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING, district STRING, addresses STRING, rentOrSell STRING, kindOfRoom STRING, typeOfObject STRING, location STRING, numOfRooms STRING, square STRING, numOfRooms STRING, condition STRING, heating STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: HouseSell
CREATE TABLE HouseSell (ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING, cytyDistrict STRING, fullAddress STRING, distanceToCity INTEGER, landSquare STRING, houseSquare STRING, typeOfHouse STRING, buildingsList STRING, communications STRING, communicationsList STRING, docs STRING, docList STRING, costUah INTEGER, costUsd INTEGER, common STRING);

-- Таблица: HouseSellImage
CREATE TABLE HouseSellImage (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, houseSellID INTEGER REFERENCES HouseSell (ID) ON DELETE CASCADE);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
