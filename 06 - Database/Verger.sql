/*==============================================================*/
/* DBMS name:      SAP SQL Anywhere 16                          */
/* Created on:     12-Jan-19 20:25:04                           */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_A_A_VERGER') then
    alter table A
       delete foreign key FK_A_A_VERGER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_A_A2_SAISON') then
    alter table A
       delete foreign key FK_A_A2_SAISON
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_DEPENCE_PAYE_VERGER') then
    alter table DEPENCE
       delete foreign key FK_DEPENCE_PAYE_VERGER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EMPLOYE_LOUE_VERGER') then
    alter table EMPLOYE
       delete foreign key FK_EMPLOYE_LOUE_VERGER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_FACTURE__POSSEDE_VERGER') then
    alter table FACTURE_DU_MARCHE
       delete foreign key FK_FACTURE__POSSEDE_VERGER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PAYEMENT_AVOIRF_EMPLOYE') then
    alter table PAYEMENT_FIXE
       delete foreign key FK_PAYEMENT_AVOIRF_EMPLOYE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PAYEMENT_AVOIRNF_EMPLOYE') then
    alter table PAYEMENT_NON_FIXE
       delete foreign key FK_PAYEMENT_AVOIRNF_EMPLOYE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_RECEVOIE_RECEVOIE_VERGER') then
    alter table RECEVOIE
       delete foreign key FK_RECEVOIE_RECEVOIE_VERGER
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_RECEVOIE_RECEVOIE2_ENTRERS') then
    alter table RECEVOIE
       delete foreign key FK_RECEVOIE_RECEVOIE2_ENTRERS
end if;

drop index if exists A.A2_FK;

drop index if exists A.A_FK;

drop index if exists A.A_PK;

drop table if exists A;

drop index if exists DEPENCE.PAYE_FK;

drop index if exists DEPENCE.DEPENCE_PK;

drop table if exists DEPENCE;

drop index if exists EMPLOYE.LOUE_FK;

drop index if exists EMPLOYE.EMPLOYE_PK;

drop table if exists EMPLOYE;

drop index if exists ENTRERS.ENTRERS_PK;

drop table if exists ENTRERS;

drop index if exists FACTURE_DU_MARCHE.POSSEDE_FK;

drop index if exists FACTURE_DU_MARCHE.FACTURE_DU_MARCHE_PK;

drop table if exists FACTURE_DU_MARCHE;

drop index if exists PAYEMENT_FIXE.AVOIRF_FK;

drop index if exists PAYEMENT_FIXE.PAYEMENT_FIXE_PK;

drop table if exists PAYEMENT_FIXE;

drop index if exists PAYEMENT_NON_FIXE.AVOIRNF_FK;

drop index if exists PAYEMENT_NON_FIXE.PAYEMENT_NON_FIXE_PK;

drop table if exists PAYEMENT_NON_FIXE;

drop index if exists RECEVOIE.RECEVOIE2_FK;

drop index if exists RECEVOIE.RECEVOIE_FK;

drop index if exists RECEVOIE.RECEVOIE_PK;

drop table if exists RECEVOIE;

drop index if exists SAISON.SAISON_PK;

drop table if exists SAISON;

drop index if exists VERGER.VERGER_PK;

drop table if exists VERGER;

/*==============================================================*/
/* Table: A                                                     */
/*==============================================================*/
create table A 
(
   NOMV                 varchar(20)                    not null,
   IDS                  integer                        not null,
   constraint PK_A primary key clustered (NOMV, IDS)
);

/*==============================================================*/
/* Index: A_PK                                                  */
/*==============================================================*/
create unique clustered index A_PK on A (
NOMV ASC,
IDS ASC
);

/*==============================================================*/
/* Index: A_FK                                                  */
/*==============================================================*/
create index A_FK on A (
NOMV ASC
);

/*==============================================================*/
/* Index: A2_FK                                                 */
/*==============================================================*/
create index A2_FK on A (
IDS ASC
);

/*==============================================================*/
/* Table: DEPENCE                                               */
/*==============================================================*/
create table DEPENCE 
(
   IDD                  integer                        not null Identity,
   NOMV                 varchar(20)                    not null,
   DATED                date                           not null,
   PAYE_POUR            varchar(50)                    null,
   ARTICLE              varchar(50)                    null,
   MONTANTD             numeric(10,4)                  null,
   MACHINE              varchar(50)                    null,
   NOTED                varchar(100)                   null,
   constraint PK_DEPENCE primary key clustered (IDD)
);
insert into DEPENCE values('','','','',12.5,'','');
UPDATE DEPENCE SET DATED='',NOMV='',PAYE_POUR='',ARTICLE='',MONTANTD=7,MACHINE='',NOTED='' WHERE IDD=1;
select  * from DEPENCE
SELECT * FROM DEPENCE WHERE DATED>='2000-01-01' AND DATED<='2019-01-12' ORDER BY DATED ASC
delete from DEPENCE
drop table DEPENCE
/*==============================================================*/
/* Index: DEPENCE_PK                                            */
/*==============================================================*/
create unique clustered index DEPENCE_PK on DEPENCE (
IDD ASC
);

/*==============================================================*/
/* Index: PAYE_FK                                               */
/*==============================================================*/
create index PAYE_FK on DEPENCE (
NOMV ASC
);

/*==============================================================*/
/* Table: EMPLOYE                                               */
/*==============================================================*/
create table EMPLOYE 
(
   IDEM                 integer                        not null Identity,
   NOMV                 varchar(20)                    null,
   PRENOMEM             varchar(20)                    not null,
   NOMEM                varchar(20)                    null,
   DATE_EXP_SEJOUR      date                           null,
   MODE_DE_PAYEMENT		integer						   null,
   constraint PK_EMPLOYE primary key clustered (IDEM)
);
insert into EMPLOYE values('a','b','c','2000-01-01');
UPDATE EMPLOYE SET NOMV='',PRENOMEM='',NOMEM='',DATE_EXP_SEJOUR='' WHERE IDD=1;
select  * from EMPLOYE
SELECT * FROM EMPLOYE
SELECT * FROM EMPLOYE WHERE DATE_EXP_SEJOUR>='2000-01-01' AND DATE_EXP_SEJOUR<='2019-01-12' ORDER BY DATED ASC
delete from EMPLOYE
drop table EMPLOYE
ALTER TABLE EMPLOYE
ADD MODE_DE_PAYEMENT integer null ;
UPDATE EMPLOYE SET NOMV='',PRENOMEM='',NOMEM='',DATE_EXP_SEJOUR='',MODE_DE_PAYEMENT=1 WHERE IDEM=20;
/*==============================================================*/
/* Index: EMPLOYE_PK                                            */
/*==============================================================*/
create unique clustered index EMPLOYE_PK on EMPLOYE (
IDEM ASC
);

/*==============================================================*/
/* Index: LOUE_FK                                               */
/*==============================================================*/
create index LOUE_FK on EMPLOYE (
NOMV ASC
);

/*==============================================================*/
/* Table: ENTRERS                                               */
/*==============================================================*/
create table ENTRERS 
(
   IDE                  integer                        not null,
   DATEE                date                           not null,
   EXPEDITEUR           varchar(20)                    not null,
   MONTANTE             numeric(10,4)                  not null,
   FOURNISSEUR          varchar(20)                    null,
   NOTEE                varchar(100)                   null,
   constraint PK_ENTRERS primary key clustered (IDE)
);

/*==============================================================*/
/* Index: ENTRERS_PK                                            */
/*==============================================================*/
create unique clustered index ENTRERS_PK on ENTRERS (
IDE ASC
);

/*==============================================================*/
/* Table: FACTURE_DU_MARCHE                                     */
/*==============================================================*/
create table FACTURE_DU_MARCHE 
(
   IDFM                 integer                        not null,
   NOMV                 varchar(20)                    not null,
   DATEFM               date                           not null,
   NOMMARCHEE           varchar(50)                    null,
   QTE                  integer                        null,
   PRIX                 integer                        null,
   constraint PK_FACTURE_DU_MARCHE primary key clustered (IDFM)
);

/*==============================================================*/
/* Index: FACTURE_DU_MARCHE_PK                                  */
/*==============================================================*/
create unique clustered index FACTURE_DU_MARCHE_PK on FACTURE_DU_MARCHE (
IDFM ASC
);

/*==============================================================*/
/* Index: POSSEDE_FK                                            */
/*==============================================================*/
create index POSSEDE_FK on FACTURE_DU_MARCHE (
NOMV ASC
);

/*==============================================================*/
/* Table: PAYEMENT_FIXE                                         */
/*==============================================================*/
create table PAYEMENT_FIXE 
(
   IDPF                 integer                        not null,
   IDEM                 integer                        null,
   DATEPF               date                           null,
   MONTANTF             integer                        null,
   constraint PK_PAYEMENT_FIXE primary key clustered (IDPF)
);

/*==============================================================*/
/* Index: PAYEMENT_FIXE_PK                                      */
/*==============================================================*/
create unique clustered index PAYEMENT_FIXE_PK on PAYEMENT_FIXE (
IDPF ASC
);

/*==============================================================*/
/* Index: AVOIRF_FK                                             */
/*==============================================================*/
create index AVOIRF_FK on PAYEMENT_FIXE (
IDEM ASC
);

/*==============================================================*/
/* Table: PAYEMENT_NON_FIXE                                     */
/*==============================================================*/
create table PAYEMENT_NON_FIXE 
(
   IDPNF                integer                        not null,
   IDEM                 integer                        null,
   DATEPNF              date                           null,
   NBH_ABSCENT          integer                        null,
   NBH_PLUS             integer                        null,
   NBJ_TRAVAILLE        integer                        null,
   MONTANTNF            integer                        null,
   constraint PK_PAYEMENT_NON_FIXE primary key clustered (IDPNF)
);

/*==============================================================*/
/* Index: PAYEMENT_NON_FIXE_PK                                  */
/*==============================================================*/
create unique clustered index PAYEMENT_NON_FIXE_PK on PAYEMENT_NON_FIXE (
IDPNF ASC
);

/*==============================================================*/
/* Index: AVOIRNF_FK                                            */
/*==============================================================*/
create index AVOIRNF_FK on PAYEMENT_NON_FIXE (
IDEM ASC
);

/*==============================================================*/
/* Table: RECEVOIE                                              */
/*==============================================================*/
create table RECEVOIE 
(
   NOMV                 varchar(20)                    not null,
   IDE                  integer                        not null,
   constraint PK_RECEVOIE primary key clustered (NOMV, IDE)
);

/*==============================================================*/
/* Index: RECEVOIE_PK                                           */
/*==============================================================*/
create unique clustered index RECEVOIE_PK on RECEVOIE (
NOMV ASC,
IDE ASC
);

/*==============================================================*/
/* Index: RECEVOIE_FK                                           */
/*==============================================================*/
create index RECEVOIE_FK on RECEVOIE (
NOMV ASC
);

/*==============================================================*/
/* Index: RECEVOIE2_FK                                          */
/*==============================================================*/
create index RECEVOIE2_FK on RECEVOIE (
IDE ASC
);

/*==============================================================*/
/* Table: SAISON                                                */
/*==============================================================*/
create table SAISON 
(
   IDS                  integer                        not null,
   DATEDEB              date                           not null,
   DATEFIN              date                           null,
   constraint PK_SAISON primary key clustered (IDS)
);

/*==============================================================*/
/* Index: SAISON_PK                                             */
/*==============================================================*/
create unique clustered index SAISON_PK on SAISON (
IDS ASC
);

/*==============================================================*/
/* Table: VERGER                                                */
/*==============================================================*/
create table VERGER 
(
   NOMV                 varchar(20)                    not null,
   SURFACEV             real                           not null,
   LOCATIONV            varchar(20)                    null,
   constraint PK_VERGER primary key clustered (NOMV)
);
SELECT * FROM VERGER
insert into VERGER values('Mazraa',12.5,'Zreirieh');
/*==============================================================*/
/* Index: VERGER_PK                                             */
/*==============================================================*/
create unique clustered index VERGER_PK on VERGER (
NOMV ASC
);

alter table A
   add constraint FK_A_A_VERGER foreign key (NOMV)
      references VERGER (NOMV)
      on update restrict
      on delete restrict;

alter table A
   add constraint FK_A_A2_SAISON foreign key (IDS)
      references SAISON (IDS)
      on update restrict
      on delete restrict;

alter table DEPENCE
   add constraint FK_DEPENCE_PAYE_VERGER foreign key (NOMV)
      references VERGER (NOMV)
      on update restrict
      on delete restrict;

alter table EMPLOYE
   add constraint FK_EMPLOYE_LOUE_VERGER foreign key (NOMV)
      references VERGER (NOMV)
      on update restrict
      on delete restrict;

alter table FACTURE_DU_MARCHE
   add constraint FK_FACTURE__POSSEDE_VERGER foreign key (NOMV)
      references VERGER (NOMV)
      on update restrict
      on delete restrict;

alter table PAYEMENT_FIXE
   add constraint FK_PAYEMENT_AVOIRF_EMPLOYE foreign key (IDEM)
      references EMPLOYE (IDEM)
      on update restrict
      on delete restrict;

alter table PAYEMENT_NON_FIXE
   add constraint FK_PAYEMENT_AVOIRNF_EMPLOYE foreign key (IDEM)
      references EMPLOYE (IDEM)
      on update restrict
      on delete restrict;

alter table RECEVOIE
   add constraint FK_RECEVOIE_RECEVOIE_VERGER foreign key (NOMV)
      references VERGER (NOMV)
      on update restrict
      on delete restrict;

alter table RECEVOIE
   add constraint FK_RECEVOIE_RECEVOIE2_ENTRERS foreign key (IDE)
      references ENTRERS (IDE)
      on update restrict
      on delete restrict;

