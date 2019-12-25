# Seafile Java SDK

This is a Java SDK for  interfaces provided in [Seafile Web API v2.1](https://download.seafile.com/published/web-api/home.md)

Last updated on 2019/12/25

## Release History & Plan

- v1.0 2019/04/16 pre-released
- v1.5 2019/04/20 ***current version*** supports a part of interfaces in API v2.0 (a previous version)
- v2.0  ***next version*** will support a part of interfaces in API v2.1
- v2.1  ***future version*** will support all interfaces in API v2.1

## Package Dependence

- [OkHttp](https://square.github.io/okhttp/) (tested under v4.2.2)
- [fastjson](https://github.com/alibaba/fastjson/wiki) (tested under v1.2.62)

## Get Started

1. Download [seafilejavasdk-v1.5.0.jar](https://github.com/IchigoJuice/SeafileJavaSDK/releases/download/v1.5/seafilejavasdk-1.5.0.jar) and import it to your project
2. Add `import seafilejavasdk.*` in your Java files
3. Enjoy it!

## Available Status for API v2.0

Last updated on 2019/04/26

- ✔️ Supported and tested
- 🚩 Supported but not tested
- ❌ Not supported yet / To be supported
- ⭕️ This interface is provided in API v2.1, or broken in API v2.0 but available in API v2.1
- ~~❌~~ This interface is no longer provided in API v2.1

| Interface | Status | Interface | Status |
| -- | :--: | -- | :--: |
| **module** ***Ping*** | | | |
| Ping | ✔️ | Obtain Auth Token | ✔️ |
| Auth Ping | ✔️ | | |
| **module** ***Account*** | | | |
| List Accounts (ADMIN ONLY) | ✔️ | Get Account Info (ADMIN ONLY) | ✔️ |
| Create Accounts (ADMIN ONLY) | ✔️ | Update Account (ADMIN ONLY) | ✔️ |
| Migrate Accounts (ADMIN ONLY) | ✔️ | Delete Account (ADMIN ONLY) | ✔️ |
| ~~Force 2-Factor Auth (ADMIN ONLY)~~ | ~~❌~~ | Ckeck Account Info | ✔️ |
| Get Server Info | ✔️ | | |
| **module** ***Starred Files*** | | | |
| List Starred Files | ✔️ | Star a File | ✔️ |
| Unstar a File | ✔️ | | |
| **module** ***Group*** | ❌ | | |
| **module** ***Share*** | ❌ | | |
| **module** ***Library*** | | | |
| Get Default Library | ✔️ | Create Default Library | ✔️ |
| List Libraries | ✔️ | Get Library Info | ✔️ |
| Get Library Owner | ✔️ | Get Library History | ✔️ |
| Create Library | ✔️ | Check / Create Sub Library | ❌ |
| Delete Library | ✔️ | Rename Library | ✔️ |
| Decrypt Library | ✔️ | Create Public Library | ❌ |
| Remove Public Library | ❌ | Fetch Library Download Info | ✔️ |
| List Virtual Libraries | ❌ | Search Libraries | ❌ |
| **module** ***File*** | | | |
| View File through OWA (PRO EDITION ONLY) | 🚩 | Download File | ✔️ |
| Get File Detail | ✔️ | Get File History | ✔️ |
| Download File from a Revision | ✔️ | Create File | ✔️ |
| Rename File | ✔️ | Lock File (PRO EDITION ONLY) | 🚩 |
| Unlock File (PRO EDITION ONLY) | 🚩 | Move File | ✔️ |
| Copy File | ✔️ | Revert File | ✔️ |
| Delete File | ✔️ | Upload File | ✔️ |
| Update File | ✔️ | Get Upload Blocks Link | ❌ |
| Get Update Blocks Link | ❌ | | |
| **module** ***Directory*** | | | |
| List Directory Entries | ✔️ | Create New Directory | ✔️ |
| Rename Directory | ✔️ | Delete Directory | ✔️ |
| Download Directory | ⭕️ | Share Directory | ❌ |
| **module** ***Multiple Files or Directories*** | | | |
| Copy | ✔️ | Move | ✔️ |
| Delete | ✔️ | | |
| **module** ***Avatar*** | | | |
| Update User Avatar | ⭕️ | Get User Avatar | ✔️ |
| Get Group Avatar | ❌ | | |
| ***Others*** | | | |
| Get File Activities | ❌ | Get Thumbnail Image | ❌ |
| Add Organization | ❌ | | |

## Available Status for API v2.1

[Available Status for API v2.1](https://trello.com/b/wniRpnjH/seafile-java-sdk)
