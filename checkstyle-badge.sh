#!/bin/bash

if [ ! -f target/checkstyle/checkstyle-result.xml ]; then
    echo "Le fichier Checkstyle XML n'existe pas."
    exit 1
fi

# On Compte les erreurs et avertissements dans le rapport Checkstyle
errors=$(xmllint --xpath "count(//error[@severity='error'])" target/checkstyle/checkstyle-result.xml)
warnings=$(xmllint --xpath "count(//error[@severity='warning'])" target/checkstyle/checkstyle-result.xml)

if [ "$errors" -gt 0 ]; then
    badge="Errors:$errors-red"  
elif [ "$warnings" -gt 0 ]; then
    badge="Warnings:$warnings-yellow"  
else
    badge="OK-green"  
fi

badge_url="https://img.shields.io/badge/$badge?style=flat-square"

echo "Badge URL : $badge_url"

echo $badge_url > target/checkstyle/checkstyle-badge-url.txt
