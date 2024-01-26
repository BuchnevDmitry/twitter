--liquibase formatted sql

--changeset DmitryBuchnev:create-twitter-schema
--comment create new schema
create schema twitter;
--rollback drop schema twitter;
