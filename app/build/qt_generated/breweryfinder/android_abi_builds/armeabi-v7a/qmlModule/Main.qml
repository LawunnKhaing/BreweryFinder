// Copyright (C) 2024 The Qt Company Ltd.
// SPDX-License-Identifier: LicenseRef-Qt-Commercial OR GPL-3.0-only WITH Qt-GPL-exception-1.0

import QtQuick
import QtQuick
import QtQuick 2.15
import QtQuick.Controls 2.15

Rectangle {
    width: 640
    height: 480
    color: "black"

    property string northernMostBrewery: "Loading..."
    property string southernMostBrewery: "Loading..."
    property string longestNameBrewery: "Loading..."

    Column {
        anchors.centerIn: parent
        spacing: 10

        Text {
            color: "white"
            text: "Northern Most Brewery: " + northernMostBrewery
        }

        Text {
            color: "white"
            text: "Southern Most Brewery: " + southernMostBrewery
        }

        Text {
            color: "white"
            text: "Longest Name Brewery: " + longestNameBrewery
        }

         Component.onCompleted: {
                console.log("northernMostBrewery: " + northernMostBrewery);
                console.log("southernMostBrewery: " + southernMostBrewery);
                console.log("longestNameBrewery: " + longestNameBrewery);
            }
        }
    }



