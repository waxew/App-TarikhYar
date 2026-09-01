# TarikhYar — Figma / Compose Handoff

Figma master file:
https://www.figma.com/design/k6zg11yiKZ3m3Yy4LtuG7S

This document keeps the Figma design and the Android Jetpack Compose source synchronized.

## Screen map

| Figma screen | Figma node | Compose source |
|---|---:|---|
| Splash | `10:5` | `app/src/main/java/ir/tarikhyar/app/MainActivity.kt` + `TarikhYarApp.kt` |
| Home | `10:22` | `feature/home/HomeScreen.kt` |
| Age Calculator | `10:113` | `feature/age/AgeScreen.kt` |
| Birth Information | `10:164` | `feature/birthinfo/BirthInfoScreen.kt` |
| Chinese Zodiac | `10:240` | `feature/chinese/ChineseAstrologyScreen.kt` |
| Age Events | `10:297` | `feature/events/AgeEventsScreen.kt` |
| Date Difference | `10:400` | `feature/difference/DifferenceScreen.kt` |
| Birth Insights | `10:453` | `feature/insights/InsightsScreen.kt` |
| Persian Calendar | `14:5` | `feature/calendar/CalendarScreen.kt` |
| Personal Events | `14:110` | `feature/personalevents/PersonalEventsScreen.kt` |
| Profiles | `14:202` | `feature/profiles/ProfilesScreen.kt` |
| Favorites | `14:253` | `feature/favorites/FavoritesScreen.kt` |
| Professional Tools | `14:307` | `feature/protools/ProfessionalToolsScreen.kt` |
| Tools | `14:361` | `feature/tools/ToolsScreen.kt` |
| Settings | `15:5` | `feature/settings/SettingsScreen.kt` |
| Notifications | `15:59` | `feature/notifications/NotificationsScreen.kt` |
| Backup & Restore | `15:107` | `feature/backup/BackupScreen.kt` |
| About Software | `15:152` | `feature/about/AboutScreens.kt` |
| Contact | `15:177` | `feature/about/AboutScreens.kt` |
| Hamburger Drawer | `15:203` | `ui/components/AppDrawer.kt` |
| Widget Preview | `15:242` | `widget/TarikhYarWidgetProvider.kt` |
| Update Checker | `15:269` | `core/system/AppServices.kt` |

## Figma sections already created

- `00 — Cover` — node `9:2`
- `01 — Design System` — node `9:42`
- `02 — Components` — node `9:118`
- `03 — Core Screens` — node `10:2`
- `04 — Management Screens` — node `14:2`
- `05 — Settings & System` — node `15:2`
- `06 — States & Dialogs` — node `15:295`
- `07 — Flows & Prototype` — node `15:383`
- `09 — Architecture` — node `15:520`

## Design token map

- Colors / theme: `core/ui/theme/Color.kt`, `core/ui/theme/Theme.kt`
- Persian calendar engine: `core/date/PersianCalendar.kt`
- Date calculations: `core/date/DateCalculations.kt`
- Birth insights and zodiac: `core/date/BirthInsights.kt`
- Number/date formatting: `core/format/PersianFormat.kt`
- Local data: `core/data/LocalData.kt`
- Preferences/settings: `core/system/UserSettings.kt`
- Reminders: `core/system/ReminderScheduler.kt`
- Backup encryption: `core/system/BackupManager.kt`
- Share cards: `core/system/ShareCardRenderer.kt`
- Shared Compose components: `ui/components/CommonComponents.kt`
- Drawer: `ui/components/AppDrawer.kt`
- Persian date picker: `ui/components/PersianDatePicker.kt`

## Design rules

1. Figma is the visual source of truth for layout, spacing, color, state, and flow.
2. GitHub is the source of truth for buildable Kotlin/Compose logic.
3. Persian UI remains RTL-first and uses the warm red/cream TarikhYar visual language.
4. Back navigation must return to the previous screen before exiting the app.
5. Every interactive screen must define loading, empty, error, and permission states where relevant.
6. Dark/light theme, large text, notification permission, offline behavior, and update-safe release requirements must be preserved.
7. Signing keys and passwords must never be stored in the public repository or Figma.

## Remaining Figma handoff work

The Starter Figma MCP quota was reached while creating the in-canvas Developer Handoff section. The source map above preserves all node IDs and file mappings so Code Connect / in-canvas handoff can be completed when the quota is available again.

Planned final Figma additions:
- in-canvas `08 — Developer Handoff` table
- Web Companion desktop screen
- Code Connect mappings for shared Compose components
- light/dark comparison boards
- accessibility annotations and final visual QA
