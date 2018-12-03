
/*==============================================================*/
/* Table : ADMIN                                                */
/*==============================================================*/
create table ADMIN (
   IDADMIN              INT4                 not null,
   IDROLE               INT4                 not null,
   SURNOM               VARCHAR(50)          not null,
   LOGIN                VARCHAR(100)         not null,
   MOTDEPASSE           VARCHAR(100)         not null,
   constraint PK_ADMIN primary key (IDADMIN)
);

/*==============================================================*/
/* Index : ADMIN_PK                                             */
/*==============================================================*/
create unique index ADMIN_PK on ADMIN (
IDADMIN
);

/*==============================================================*/
/* Index : ROLE_ADMIN_FK                                        */
/*==============================================================*/
create  index ROLE_ADMIN_FK on ADMIN (
IDROLE
);

/*==============================================================*/
/* Table : DEMANDEMATCH                                         */
/*==============================================================*/
create table DEMANDEMATCH (
   IDDEMANDEMATCH       INT4                 not null,
   IDDEMANDEUR          INT4                 not null,
   IDRECEPTEUR          INT4                 not null,
   DUREE                INT4                 not null,
   DATEDEMANDE          DATE                 not null,
   DATEEXPIRATION       DATE                 not null,
   APROUVEE             INT4                 not null,
   constraint PK_DEMANDEMATCH primary key (IDDEMANDEMATCH)
);

/*==============================================================*/
/* Index : DEMANDEMATCH_PK                                      */
/*==============================================================*/
create unique index DEMANDEMATCH_PK on DEMANDEMATCH (
IDDEMANDEMATCH
);

/*==============================================================*/
/* Index : DEMANDE_DEMANDEUR_FK                                 */
/*==============================================================*/
create  index DEMANDE_DEMANDEUR_FK on DEMANDEMATCH (
IDDEMANDEUR
);

/*==============================================================*/
/* Index : DEMANDE_RECEPTEUR_FK                                 */
/*==============================================================*/
create  index DEMANDE_RECEPTEUR_FK on DEMANDEMATCH (
IDRECEPTEUR
);

/*==============================================================*/
/* Table : JOUEUR                                               */
/*==============================================================*/
create table JOUEUR (
   IDJOUEUR             INT4                 not null,
   LOGIN                VARCHAR(100)         not null,
   MOTDEPASSE           VARCHAR(100)         not null,
   STATUS               BOOL                 not null,
   APROUVE              INT4                 not null,
   PHOTO           		VARCHAR(200)         not null,
   constraint PK_JOUEUR primary key (IDJOUEUR)
);

/*==============================================================*/
/* Index : JOUEUR_PK                                            */
/*==============================================================*/
create unique index JOUEUR_PK on JOUEUR (
IDJOUEUR
);

/*==============================================================*/
/* Table : MATCH                                                */
/*==============================================================*/
create table MATCH (
   IDMATCH              INT4                 not null,
   IDDEMANDEMATCH       INT4                 not null,
   DATEMATCH            DATE                 not null,
   SCOREDEMANDEUR       INT4                 not null,
   SCORERECEPTEUR       INT4                 not null,
   DATEDEBUT            DATE                 not null,
   DATEFIN              DATE                 not null,
   constraint PK_MATCH primary key (IDMATCH)
);

/*==============================================================*/
/* Index : MATCH_PK                                             */
/*==============================================================*/
create unique index MATCH_PK on MATCH (
IDMATCH
);

/*==============================================================*/
/* Index : MATCH_DEMANDE_FK                                     */
/*==============================================================*/
create  index MATCH_DEMANDE_FK on MATCH (
IDDEMANDEMATCH
);

/*==============================================================*/
/* Table : MESSAGE                                              */
/*==============================================================*/
create table MESSAGE (
   IDMESSAGE            INT4                 not null,
   IDENVOYEUR           INT4                 not null,
   IDRECEPTEUR          INT4                 not null,
   CORPS                TEXT                 not null,
   APROUVE              INT4                 not null,
   AFFICHAGE            BOOL                 not null,
   DATEENVOYE           DATE                 not null,
   STATUS               BOOL                 not null,
   constraint PK_MESSAGE primary key (IDMESSAGE)
);

/*==============================================================*/
/* Index : MESSAGE_PK                                           */
/*==============================================================*/
create unique index MESSAGE_PK on MESSAGE (
IDMESSAGE
);

/*==============================================================*/
/* Index : MESSAGE_JOUEUR_ENVOYEUR_FK                           */
/*==============================================================*/
create  index MESSAGE_JOUEUR_ENVOYEUR_FK on MESSAGE (
IDRECEPTEUR
);

/*==============================================================*/
/* Index : MESSAGE_JOUEUR_RECEPTEUR_FK                          */
/*==============================================================*/
create  index MESSAGE_JOUEUR_RECEPTEUR_FK on MESSAGE (
IDENVOYEUR
);

/*==============================================================*/
/* Table : ROLE                                                 */
/*==============================================================*/
create table ROLE (
   IDROLE               INT4                 not null,
   NOM                  VARCHAR(50)          not null,
   DEGRE                INT4                 not null,
   constraint PK_ROLE primary key (IDROLE)
);

/*==============================================================*/
/* Index : ROLE_PK                                              */
/*==============================================================*/
create unique index ROLE_PK on ROLE (
IDROLE
);


CREATE TABLE cron
(
  idcron integer NOT NULL,
  idenvoyeur integer NOT NULL,
  idrecepteur integer NOT NULL,
  active boolean NOT NULL,
  CONSTRAINT pk_cron PRIMARY KEY (idcron),
  CONSTRAINT fk_cron_envoyeur_joueur FOREIGN KEY (idenvoyeur) REFERENCES joueur (idjoueur) ,
  CONSTRAINT fk_cron_recepteur_joueur FOREIGN KEY (idrecepteur) REFERENCES joueur (idjoueur)
)

alter table ADMIN
   add constraint FK_ADMIN_ROLE_ADMI_ROLE foreign key (IDROLE)
      references ROLE (IDROLE)
      on delete restrict on update restrict;

alter table DEMANDEMATCH
   add constraint FK_DEMANDEM_DEMANDEUR_JOUEUR foreign key (IDDEMANDEUR)
      references JOUEUR (IDJOUEUR)
      on delete restrict on update restrict;

alter table DEMANDEMATCH
   add constraint FK_DEMANDEM_DEMANDE_R_JOUEUR foreign key (IDRECEPTEUR)
      references JOUEUR (IDJOUEUR)
      on delete restrict on update restrict;

alter table MATCH
   add constraint FK_MATCH_MATCH_DEM_DEMANDEM foreign key (IDDEMANDEMATCH)
      references DEMANDEMATCH (IDDEMANDEMATCH)
      on delete restrict on update restrict;

alter table MESSAGE
   add constraint FK_MESSAGE_ENVOYEUR_JOUEUR foreign key (IDRECEPTEUR)
      references JOUEUR (IDJOUEUR)
      on delete restrict on update restrict;

alter table MESSAGE
   add constraint FK_MESSAGE_RECEPTEUR_JOUEUR foreign key (IDENVOYEUR)
      references JOUEUR (IDJOUEUR)
      on delete restrict on update restrict;

