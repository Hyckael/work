/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  12/02/2023 12:31:00                      */
/*==============================================================*/


drop table if exists ADMINISTRATEUR;

drop table if exists CLIENT;

drop table if exists FACTURE;

drop table if exists MATERIEL;

drop table if exists RESERVATION;

/*==============================================================*/
/* Table : ADMINISTRATEUR                                       */
/*==============================================================*/
create table ADMINISTRATEUR
(
   ID_ADMIN_            int not null auto_increment,
   USER_NAME            varchar(50),
   MOT_PASS             varchar(100),
   NOM                  varchar(50),
   PRENOM               varchar(80),
   E_MAIL               varchar(100),
   primary key (ID_ADMIN_)
);

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT
(
   ID_CLIENT            int not null auto_increment,
   ID_ADMIN_            int not null,
   NOM_CLIENT           varchar(80),
   PRENOM_              varchar(90),
   CONTACT_CLIENT       varchar(60),
   DOMICILE_CLIENT      varchar(90),
   CODE_CNI             varchar(80),
   primary key (ID_CLIENT)
);

/*==============================================================*/
/* Table : FACTURE                                              */
/*==============================================================*/
create table FACTURE
(
   ID_FACTURE_          int not null auto_increment,
   ID_RESERVATION       int not null,
   AMENDE               float(8,2),
   MONTANT_ANVANCE      float(8,2),
   DATE_AVANCE          date,
   DATE_FIN_PAIEMENT    date,
   MONTATNT_A_PAYER     float(8,2),
   INTITULE_AMENDE      varchar(100),
   DATE_LIVRAISON       date,
   LIEU_LIVRAISON       varchar(80),
   LIVRER               varchar(50),
   RESTE_A_PAYER        float(8,2),
   RETOURNER            varchar(50),
   ETAT_MATERIEL        varchar(50),
   DATE_RETOUR          datetime,
   primary key (ID_FACTURE_)
);

/*==============================================================*/
/* Table : MATERIEL                                             */
/*==============================================================*/
create table MATERIEL
(
   ID_MATERIEL          int not null auto_increment,
   NOM_MATERIEL         varchar(100),
   DESC_MATERIEL        varchar(100),
   PRIX                 float(8,2),
   QUANTITE             int,
   primary key (ID_MATERIEL)
);

/*==============================================================*/
/* Table : RESERVATION                                          */
/*==============================================================*/
create table RESERVATION
(
   ID_RESERVATION       int not null auto_increment,
   ID_CLIENT            int not null,
   ID_MATERIEL          int,
   DATE_DEBUT_RESERVATION date,
   DATE_FIN_RESERVATION date,
   QUANTITE_RESERVEE    int,
   primary key (ID_RESERVATION)
);

alter table CLIENT add constraint FK_ENREGISTRER foreign key (ID_ADMIN_)
      references ADMINISTRATEUR (ID_ADMIN_) on delete restrict on update restrict;

alter table FACTURE add constraint FK_CONCERNER foreign key (ID_RESERVATION)
      references RESERVATION (ID_RESERVATION) on delete restrict on update restrict;

alter table RESERVATION add constraint FK_COMPRENDRE foreign key (ID_MATERIEL)
      references MATERIEL (ID_MATERIEL) on delete restrict on update restrict;

alter table RESERVATION add constraint FK_EFFECTUER foreign key (ID_CLIENT)
      references CLIENT (ID_CLIENT) on delete restrict on update restrict;

