"""TechScan 엔진 자리표시(stub) CLI.

실제 엔진(techdd_korea_universal 의 core 태그를 subtree 로 가져올 예정)이 붙기 전까지
devfile 명령의 실행 경로(컨테이너·작업 폴더·git diff 범위·SARIF 출력)를 확인하기 위한 것이다.
분석은 하지 않는다. 변경 파일마다 level=note 결과 1건을 SARIF 2.1.0 으로 출력한다.

사용법: python -m engine.cli scan <path> --diff <base>..<head> --format sarif
"""
import argparse
import json
import subprocess
import sys

STUB_VERSION = "0.1.0-stub"


def changed_files(path, diff_range):
    out = subprocess.run(
        ["git", "-c", "safe.directory=*", "-C", path, "diff", "--name-only", diff_range],
        check=True, capture_output=True, text=True,
    ).stdout
    return [line for line in out.splitlines() if line]


def to_sarif(files, diff_range):
    return {
        "$schema": "https://json.schemastore.org/sarif-2.1.0.json",
        "version": "2.1.0",
        "runs": [{
            "tool": {"driver": {
                "name": "TechScan",
                "version": STUB_VERSION,
                "informationUri": "https://www.knowverse.net/",
                "rules": [{
                    "id": "TECHSCAN-STUB-0001",
                    "shortDescription": {"text": "Placeholder: engine not attached yet"},
                }],
            }},
            "properties": {
                "diffRange": diff_range,
                # 결과에 생성·검증 모델 식별자를 함께 싣는다(G-T: 생성 모델 != 검증 모델). stub 은 판정하지 않는다.
                "generatorModel": "unknown",
                "verifierModel": "none (stub)",
            },
            "results": [{
                "ruleId": "TECHSCAN-STUB-0001",
                "level": "note",
                "message": {"text": f"Changed in {diff_range}; real findings will appear once the engine is attached."},
                "locations": [{"physicalLocation": {
                    "artifactLocation": {"uri": f},
                    "region": {"startLine": 1},
                }}],
            } for f in files],
        }],
    }


def main(argv=None):
    p = argparse.ArgumentParser(prog="python -m engine.cli")
    sub = p.add_subparsers(dest="cmd", required=True)
    s = sub.add_parser("scan")
    s.add_argument("path")
    s.add_argument("--diff", required=True, help="<base>..<head>")
    s.add_argument("--format", choices=["sarif"], default="sarif")
    # 실제 엔진 CLI 와 같은 devfile 명령을 쓰기 위해 받기만 한다(stub 은 판정하지 않는다).
    s.add_argument("--out")
    s.add_argument("--generator-model", default="unknown")
    s.add_argument("--verify", action="store_true")
    s.add_argument("--verifier-url")
    a = p.parse_args(argv)
    files = changed_files(a.path, a.diff)
    out = open(a.out, "w", encoding="utf-8") if a.out else sys.stdout
    json.dump(to_sarif(files, a.diff), out, ensure_ascii=False, indent=2)
    out.write("\n")
    if a.out:
        out.close()
    print(f"[techscan-stub] {len(files)} changed file(s) in {a.diff}", file=sys.stderr)
    return 0


if __name__ == "__main__":
    sys.exit(main())
