/*
 * Created under not commercial project "Make it fine"
 *
 * Copyright 2017-2020
 */
OPEN SCHEMA EXASOL_YAYPAY_TEST;

INSERT INTO BIZ (ID,NAME,DEFAULT_USER_AR_ID,ADDRESS_ID,TAX_NUMBER,SETTINGS,API_KEY,IS_DEMO,INTEGRATIONS,CREATED_AT,
                 LOGO_ID,SETTINGS_INBOUND_HOST,DEFAULT_CURRENCY,VERSION,UPDATED_AT,IS_AUTOTEST,DEF_CC_ACC_ID,
                 DEF_ACH_ACC_ID,USECALCULATEDCUSTOMERBALANCE,SWITCHTOMULTICURRENCYDAILYEXCHANGERATES,BIZ_URL,
                 DEF_UNDEP_ACC,REFERENCE_NAME)
     VALUES
(1,'My Company LLC',0,1,'123456789',NULL,'378355ad4d318d1f7ceecec1a52d3d7d',false,NULL,'2017-11-11 08:46:41.000',0,NULL,'USD',0,NULL,false,NULL,
 NULL,'false','false',NULL,NULL,NULL),
(2,'NotMyBiz',0,2,NULL,NULL,'120c289d362f914078611ac0075c99c2',false,NULL,'2017-11-11 08:46:41.000',0,NULL,'USD',0,NULL,false,NULL,NULL,NULL,NULL,
 NULL,NULL,NULL),
(3,'Other biz',0,3,NULL,NULL,'82a872f8d7996b4d9944c09c950ed602',false,NULL,'2017-11-11 08:46:41.000',0,NULL,'USD',0,NULL,false,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(4,'FOP',0,4,NULL,NULL,'d8e85d5d51a2fe3bf6bba23e0a045ea5',false,NULL,'2017-11-11 08:46:41.000',0,NULL,'USD',0,NULL,false,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(5,'His biz',0,5,NULL,NULL,'4d4289c1824f9d0dd6d98a8b9b6510b2',false,NULL,'2017-11-11 08:46:41.000',0,NULL,'USD',0,NULL,false,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(6,'Kalinka OOO',0,6,NULL,NULL,'1a2cbe6ce9c4ea950219b1e5e71b8077',false,NULL,'2017-11-11 08:46:41.000',0,NULL,'USD',0,NULL,false,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(7,'Initial autotest biz',0,7,NULL,NULL,NULL,false,NULL,'2017-11-11 08:52:38.000',0,NULL,'USD',0,NULL,false,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
