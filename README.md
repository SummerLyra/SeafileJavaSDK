# Seafile Java SDK

This is a Java SDK for some interfaces provided in [Seafile Web API v2.0](https://github.com/FreezingRainYu/SeafileJavaSDK/blob/master/web_api_v2.0.md)

Last updated on 2019/04/20

## Release History

- v1.0 2019/04/16 not released
- v1.5 2019/04/20 ***current version***
- v2.0 ***next version*** will support all interfaces in SWA v2.0

## Package Dependence

- [OkHttp](https://square.github.io/okhttp/) (tested under v3.14.1)
- [fastjson](https://github.com/alibaba/fastjson/wiki) (tested under v1.2.57)

## Get Started

1. Download [seafilejavasdk-v1.5.0.jar](https://github.com/FreezingRainYu/SeafileJavaSDK/releases/download/v1.5/seafilejavasdk-1.5.0.jar) and import it to your project
2. Add `import seafilejavasdk.*` in your Java files
3. Enjoy it!

## Support Status

Last updated on 2019/04/20

- ✔️️ Tested and supported
- ❌ Not supported yet / To be supported
- 🚩 Supported but not tested
- ⭕️ This interface is provided in [Seafile Web API v2.1](https://github.com/FreezingRainYu/SeafileJavaSDK/blob/master/web_api_v2.1.md), or broken in SWA v2.0 but available in SWA v2.1

| Interface | Status | Interface | Status |
| -- | :--: | -- | :--: |
| | | | |
| **module** ***Ping*** | | | |
| Ping | ✔️ | Obtain Auth Token | ✔️ |
| Auth Ping | ✔️ | | |
| | | | |
| **module** ***Account*** | | | |
| List Accounts (Admin only) | ✔️ | Get Account Info (Admin only) | ✔️ |
| Create Accounts (Admin only) | ✔️ | Update Account (Admin only) | ❌ |
| Migrate Accounts (Admin only) | ✔️ | Delete Account (Admin only) | ✔️ |
| Force 2FA (Admin only) | ❌ | Ckeck Account Info | ✔️ |
| Get Server Info | ✔️ | | |
| | | | |
| **module** ***Starred Files*** | | | |
| List Starred Files | ✔️ | Star a File | ✔️ |
| Unstar a File | ✔️ | | |
| | | | |
| **module** ***Group*** | ❌ | | |
| | | | |
| **module** ***Share*** | ❌ | | |
| | | | |
| **module** ***Library*** | | | |
| Get Default Library | ✔️ | Create Default Library | ✔️ |
| List Libraries | ✔️ | Get Library Info | ✔️ |
| Get Library Owner | ✔️ | Get Library History | ✔️ |
| Create Library | ✔️ | Check/Create Sub Library | ❌ |
| Delete Library | ✔️ | Rename Library | ✔️ |
| Decrypt Library | ✔️ | Create Public Library | ❌ |
| Remove Public Library | ❌ | Fetch Library Download Info | ✔️ |
| List Virtual Libraries | ❌ | Search Libraries | ❌ |
| | | | |
| **module** ***File*** | | | |
| View File Through OWA | 🚩 | Download File | ✔️ |
| Get File Detail | ✔️ | Get File History | ✔️ |
| Download File from a Revision | ✔️ | Create File | ✔️ |
| Rename File | ✔️ | Lock File | 🚩 |
| Unlock File | 🚩 | Move File | ✔️ |
| Copy File | ✔️ | Revert File | ✔️ |
| Delete File | ✔️ | Upload File | ✔️ |
| Update File | ✔️ | Get Upload Blocks Link | ❌ |
| Get Update Blocks Link | ❌ | | |
| | | | |
| **module** ***Directory*** | | | |
| List Directory Entries | ✔️ | Create New Directory | ✔️ |
| Rename Directory | ✔️ | Delete Directory | ✔️ |
| Download Directory | ⭕️ | Share Directory | ❌ |
| | | | |
| **module** ***Multiple Files or Directories*** | | | |
| Copy | ✔️ | Move | ✔️ |
| Delete | ✔️ | | |
| | | | |
| **module** ***Avatar*** | | | |
| Update User Avatar | ⭕️ | Get User Avatar | ✔️ |
| Get Group Avatar | ❌ | | |
| | | | |
| ***Others*** | | | |
| Get File Activities | ❌ | Get Thumbnail Image | ❌ |
| Add Organization | ❌ | | |
| | | | |
