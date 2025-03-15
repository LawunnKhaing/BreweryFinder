// Copyright (C) 2024 The Qt Company Ltd.
// SPDX-License-Identifier: LicenseRef-Qt-Commercial OR GPL-3.0-only WITH Qt-GPL-exception-1.0

import QtQuick
import QtQuick.Controls 2.15

Rectangle {
    width: 640
    height: 480
    color: "black"

    property string northernMostBrewery: "Unknown"
    property string southernMostBrewery: "Unknown"
    property string longestNameBrewery: "Unknown"

    Column {
        anchors {
            top: parent.top
            left: parent.left
            right: parent.right
            topMargin: 40
            leftMargin: 30
            rightMargin: 30
        }
        spacing: 40

        Column {
            spacing: 10
            Text {
                text: "The Northern Most Brewery"
                font.bold: true
                font.pixelSize: 36
                color: "#FFA500"
            }
            Text {
                text: northernMostBrewery
                font.pixelSize: 30
                color: "white"
                wrapMode: Text.Wrap
            }
        }

        Column {
            spacing: 8
            Text {
                text: "The Southern Most Brewery"
                font.bold: true
                font.pixelSize: 36
                color: "#FFA500"
            }
            Text {
                text: southernMostBrewery
                font.pixelSize: 30
                color: "white"
                wrapMode: Text.Wrap
            }
        }

        Column {
            spacing: 8
            Text {
                text: "The One with the Longest Name"
                font.bold: true
                font.pixelSize: 36
                color: "#FFA500"
            }
            Text {
                text: longestNameBrewery
                font.pixelSize: 30
                color: "white"
                wrapMode: Text.Wrap
            }
        }
    }
}

