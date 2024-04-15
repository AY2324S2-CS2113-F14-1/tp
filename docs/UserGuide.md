# User Guide

* [Introduction](#introduction)
* [Quick Start](#quick-start)
* [Features](#features)
    * [1. Handling categories: category](#1-handling-categories-category)
    * [2. Adding expenses: add](#2-adding-expenses-add)
    * [3. Deleting expenses: delete](#3-deleting-expenses-delete)
    * [4. Listing expenses: list](#4-listing-expenses-list)
    * [5. Summarising expenses: summarise](#5-summarising-expenses-summarise)
    * [6. Adding events: event](#6-adding-events-event)
    * [7. Viewing events: listEvents](#7-viewing-events-listevents)
    * [8. Deleting events: deleteEvent](#8-deleting-events-deleteevent)
    * [9. Adding expenses to events: addExEv](#9-adding-expenses-to-events-addexev)
    * [10. Deleting expenses from events: delExEv](#10-deleting-expenses-from-events-delexev)
    * [11. Viewing expenses in events: viewEvent](#11-viewing-expenses-in-events-viewevent)
* [FAQ](#faq)
* [Command Summary](#command-summary)

## Introduction

Brokeculator is a CLI application designed for university students to log and view their
expenses. It aims to tackle the challenge they face of managing a myriad of expenses across various categories. For 
experienced CLI users, they can enter their expenses faster compared to GUI applications

## Quick Start

1. Ensure that you have Java 11 or above installed
2. Download the latest version of `brokeculator` from [here](https://github.com/AY2324S2-CS2113-F14-1/tp/releases)
3. Open a command terminal and `cd` to the folder you put the `brokeculator.jar` file in
4. Enter `java -jar brokeculator.jar` into the terminal to run the application
5. Refer to the Features section below for details of each command

## Features
1. Users can use the `up` and `down` arrow keys to navigate through the command history
2. Users can use the `left` and `right` arrow keys to navigate through the command line

## Commands
1. [Handling categories: category](#1-handling-categories-category)
2. [Adding expenses: add](#2-adding-expenses-add)
3. [Deleting expenses: delete](#3-deleting-expenses-delete)
4. [Listing expenses: list](#4-listing-expenses-list)
5. [Summarising expenses: summarise](#5-summarising-expenses-summarise)
6. [Adding events: event](#6-adding-events-event)
7. [Viewing events: listEvents](#7-viewing-events-listevents)
8. [Deleting events: deleteEvent](#8-deleting-events-deleteevent)
9. [Adding expenses to events: addExEv](#9-adding-expenses-to-events-addexev)
10. [Deleting expenses from events: delExEv](#10-deleting-expenses-from-events-delexev)
11. [Viewing expenses in events: viewEvent](#11-viewing-expenses-in-events-viewevent)

> **NOTE**
> 1. The commands are case-insensitive
> 2. The DATE format is `DD-MM-YYYY`
> 3. Words in `UPPER_CASE` are parameters to be supplied by the user
> 4. Parameters in square brackets are optional

> **WARNINGS**
> 1. Do not manually edit the data files located in the data folder of the application. 
    Corrupted entries may have a significant ripple effect on the data integrity of the application.
> 2. By using this application, you acknowledge and accept the risk of potential data corruption 
    due to manual editing of data files. 
> 3. Please be informed that Brokeculator restricts the use of custom file delimiters in user inputs. 
    These delimiters are specially designed strings unlikely to be naturally present in users' input. 
    Any detected instances will be considered a malicious attempt to compromise the application's data integrity 
    and will consequently be blocked.

<div style="page-break-after: always;"></div>

### 1. Handling categories: category

#### **_SYNOPSIS_**
```dtd    
category [add|list|delete] [CATEGORY_NAME]
```
#### **_DESCRIPTION_**
Main command to handle categories. `add` 
and `delete` should be accompanied by `CATEGORY_NAME`. `list` will list all categories.
When deleting a category, all expenses using that category must be deleted first.
The category specified in `add` and `delete` will be converted to uppercase.

#### **_USAGE_**

Example of adding category: <br>
```dtd
category add test1
```
output:

```dtd
------------------------------------
Category added: TEST1
------------------------------------
```
Example of deleting category: <br>
```dtd
category delete test2
```
output:
```dtd
------------------------------------
Category removed: TEST2
------------------------------------
```
Example of listing categories: <br>
```dtd
category list
```
output:
```dtd
------------------------------------
Categories:
- TEST3
- TEST1
------------------------------------
```

<div style="page-break-after: always;"></div>

### 2. Adding expenses: add
#### **_SYNOPSIS_**
```dtd
add /n EXPENSE_NAME /d DATE /a AMOUNT [/c CATEGORY]
```
#### **_DESCRIPTION_**
Adds an expense to the list of expenses tracked by the application.
The expense must have a name, date and amount.
#### **_PARAMETERS_**
`/n EXPENSE_NAME` : Name of the expense. <br>
`/d DATE` : Date of the expense in the format DD-MM-YYYY. <br>
`/a AMOUNT` : Amount of the expense. Must be a float/integer value, either 0 or 2 decimal places. 
the integer portion of the amount is limited to 7 digits <br>
#### **_OPTIONAL PARAMETERS_**
`/c CATEGORY` : Category of the expense. Category must be present in the category list.
If not present, add the category using the `category add` command. <br>
#### **_USAGE_**
Examples of usage: <br>
```dtd
add /n tea /d 14-02-2002 /a 2.50 /c food
```
```dtd
add /n coffee /d 15-02-2003 /a 3.00
```
```dtd
add /n tea /d 14-02-2024 /a 2.50 /c food
```
```dtd
add /n coffee /d 15-02-2024 /a 3.00
```
<div style="page-break-after: always;"></div>

### 3. Deleting expenses: delete
#### **_SYNOPSIS_**
```dtd    
delete /i INDEX
```
#### **_DESCRIPTION_**
Deletes the expense at the specified INDEX.
#### **_USAGE_**
Example of deleting the first expense: <br>
```dtd
delete /i 1
```
Example of deleting the fifth expense: <br>
```dtd
delete /i 5
```
<div style="page-break-after: always;"></div>

### 4. Listing expenses: list
#### **_SYNOPSIS_**
```dtd
list /a [AMOUNT_TO_LIST]
```
#### **_DESCRIPTION_**
Lists the tasks tracked by the application
#### **_OPTIONAL PARAMETERS_**
`AMOUNT_TO_LIST` : The number of tasks to list. If specified, lists the first `AMOUNT_TO_LIST` tasks. 
Must be a positive integer. If not provided, will list all tasks.
#### **_USAGE_**
Example of usage: <br>
```dtd
list
```
Example of listing the first 5 expenses: <br>
```dtd
list /a 5
```
<div style="page-break-after: always;"></div>

### 5. Summarising expenses: summarise
#### **_SYNOPSIS_**
```dtd    
summarise [/n NAME] [/start START_DATE] [/end END_DATE] 
[/c CATEGORY] [/from BEGIN_INDEX] [/to END_INDEX]
```
#### **_DESCRIPTION_**
Displays a summary of the expenses between the specified indices that match all of the user specifications. The summary
consists of the sum of the cost of said expenses as well as a list of the expenses that were summarised. If no parameters
are provided, will summarise all expenses tracked by the application. Any extraneous or invalid parameters will be disregarded.
#### **_OPTIONAL PARAMETERS_**
`/n NAME` : Expenses need to have this `NAME` to be summarised <br>
`/c CATEGORY` : Expenses need to have this `CATEGORY` to be summarised <br>
`/start START_DATE` : Expenses from this `START_DATE` onwards (inclusive) or till the end date (if specified)
will be summarised. Must be in the format `DD-MM-YYYY`. <br>
`/end END_DATE` : Expenses up to this `END_DATE` (inclusive) or from the start date (if specified) will be summarised.
Must be in the format `DD-MM-YYYY`. <br>
`/from BEGIN_INDEX` : Expenses from this `BEGIN_INDEX` onwards (inclusive) will be summarised. Must be positive integer.
If not provided, will summarise from start of list <br>
`/to END_INDEX` : Expenses up to this `END_INDEX` (inclusive) will be  summarised. Must be positive integer.
If not provided, will summarise up to end of list <br>

#### **_USAGE_**
Example of summarising all expenses: <br>
```dtd
summarise
```
Example of summarising expenses beginning from the 3rd index: <br>
```dtd
summarise /from 3
```
Example of summarising expenses up to the 5th index: <br>
```dtd
summarise /to 5
```
Example of summarising expenses between the 4th and 6th indices: <br>
```dtd
summarise /from 4 /to 6
```
Example of summarising all expenses with the name `tea`: <br>
```dtd
summarise /n tea
```
Example of summarising expenses with the date `14-02-2024` up to the 7th index: <br>
```dtd
summarise /start 14-02-2024 /end 14-02-2024 /to 7
```
Example of summarising expenses with the name `chicken` and the category `food` beginning from the 2nd index: <br>
```dtd
summarise /n chicken /c food /from 2
```
Example of summarising expenses with the date equal to or after `14-02-2024` and the category `food`: <br>
```dtd
summarise /start 14-02-2024 /c food
```
<div style="page-break-after: always;"></div>

### 6. Adding events: event
#### **_SYNOPSIS_**
```dtd
event /n EVENT_NAME /d EVENT_DESCRIPTION
```
#### **_DESCRIPTION_**
Adds an event to group expenses together. This is to be used
in conjunction with `addExEv` to add expenses to the event.
#### **_PARAMETERS_**
`/n EVENT_NAME` : Name of the event. <br>
`/d EVENT_DESCRIPTION` : Description of the event. <br>

#### **_USAGE_**
Example of adding an event with name "birthday" and description "birthday party for bob" <br>
```dtd
event /n birthday /d birthday party for bob
```

### 7. Viewing events: listEvents
#### **_SYNOPSIS_**
```dtd
listEvents
```

#### **_DESCRIPTION_**
Lists all events tracked by the application. Each event has an index associated with it.
This index can be used to add expenses to the event using the `addExEv` command.

#### **_USAGE_**
Example of usage: <br>
```dtd
listEvents
```
output:
```dtd
------------------------------------
1. Party Woohoo! (Bob's birthday)
2. Party YOYO! (Anna's wedding)
------------------------------------
```
<div style="page-break-after: always;"></div>

### 8. Deleting events: deleteEvent
#### **_SYNOPSIS_**
```dtd
deleteEvent /i INDEX
```
#### **_DESCRIPTION_**
Delete an event that you no longer wish to track. To delete
an event, you must first delete the expenses associated with the event using `delExEv`.
#### **_PARAMETERS_**
`/i INDEX` : Index of the event to be deleted. <br>

#### **_USAGE_**
Example of deleting an event at index 1 <br>
```dtd
deleteEvent /i 1
```

### 9. Adding expenses to events: addExEv
#### **_SYNOPSIS_**
```dtd
addExEv /exi EXPENSE_INDEX /evi EVENT_INDEX
```
#### **_DESCRIPTION_**
Adds an expense to an event. 

#### **_PARAMETERS_**
`/exi EXPENSE_INDEX` : Index of the expense to be added to the event. <br>
`/evi EVENT_INDEX` : Index of the event to which the expense is to be added. <br>

#### **_USAGE_**
Example of adding expense at index 1 to the event at index 1 <br>
```dtd
addExEv /exi 1 /evi 1
```
<div style="page-break-after: always;"></div>

### 10. Deleting expenses from events: delExEv
#### **_SYNOPSIS_**
```dtd
delExEv /i EXPENSE_INDEX
```
#### **_DESCRIPTION_**
Deletes an expense from its associated event. 
#### **_PARAMETERS_**
`/i EXPENSE_INDEX` : Index of the expense to be deleted from its associated event<br>

#### **_USAGE_**
Example of deleting an expense at index 1 from its owning event: <br>
```dtd  
delExEv /i 1
```

### 11. Viewing expenses in events: viewEvent
#### **_SYNOPSIS_**
```dtd
viewEvent /i EVENT_INDEX
```
#### **_DESCRIPTION_**
Displays the expenses associated with the event at the specified index.
#### **_PARAMETERS_**
`/i EVENT_INDEX` : Index of the event whose expenses are to be displayed. <br>

#### **_USAGE_**
Example of viewing the event at index 1: <br>
```dtd
viewEvent /i 1
```
output:
```dtd
------------------------------------
Party Woohoo! (Bob's birthday)
Event has 2 expenses.
Total amount spent = $35.00

1. Pizza $25.00 (Monday, 08 April 2024)
2. Soda $10.00 (Monday, 08 April 2024)
------------------------------------
```
<div style="page-break-after: always;"></div>

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: copy over the files in ./data (in the directory that you ran the jar file from)
and run the jar on your other computer. The categories, events and expenses will be automatically loaded on
application startup.

**Q**: What happens if a certain file entry is corrupted?

**A**: For corrupted entries, the application will remove the corrupted entry. However, for
objects reliant on the corrupted entry, ie) an expense that is associated with a corrupted category, some modifications
to the dependent objects will be made ie) the category of the expense will be set to null.

**Q**: Why can I add duplicate expenses and events? 

**A**: To address users' privacy concerns, we do not check users' data. 

## Command Summary

1. **Category**: 
    * Add category `category add CATEGORY_NAME`
    * List categories `category list`
    * Delete category `category delete CATEGORY_NAME`
2. **Expenses**:
    * Add expense `add /n EXPENSE_NAME /d DATE /a AMOUNT [/c CATEGORY]`
    * List expenses `list /a [AMOUNT_TO_LIST]`
    * Delete expense `delete /i INDEX`
    * summarise expenses `summarise [/n NAME] [/start START_DATE] [/end END_DATE]
      [/c CATEGORY] [/from BEGIN_INDEX] [/to END_INDEX]`
3. **Events**:
    * Add event `event /n EVENT_NAME /d EVENT_DESCRIPTION`
    * List events `listEvents`
    * Delete event `deleteEvent /i INDEX`
    * Add expense to event `addExEv /exi EXPENSE_INDEX /evi EVENT_INDEX `
    * delete expense from event `delExEv /i EXPENSE_INDEX_FROM_LIST_COMMAND`
    * List expenses in event `viewEvent /i INDEX`


